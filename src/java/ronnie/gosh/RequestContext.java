package ronnie.gosh;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;
import org.apache.taglibs.standard.functions.Functions;
import org.apache.taglibs.standard.tag.common.core.ImportSupport;
import org.apache.taglibs.standard.tag.common.core.UrlSupport;

import groovy.lang.Closure;
import groovy.lang.GString;
import groovy.xml.MarkupBuilder;

import com.logicacmg.idt.commons.SystemException;
import com.logicacmg.idt.commons.util.Assert;

public class RequestContext
{
	static final private Logger log = Logger.getLogger( RequestContext.class );
	
	static public final String GOSH_FLASHCACHE = "gosh-flashcache";
	static public final String FLASHKEY = "_flashkey";
	
	static public final Set xmlContentTypes;
	
	static
	{
		xmlContentTypes = new HashSet();
		xmlContentTypes.add( "application/xml" );
		xmlContentTypes.add( "application/xhtml+xml" );
		xmlContentTypes.add( "text/html" );
		xmlContentTypes.add( "text/xml" );
	}

	protected ApplicationContext applicationContext;
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected PrintWriter out;
	protected RequestParameters params;
	protected Map args;
	protected String controllerName;
	
	protected Map fragmentsCollector;

	// Initial	
	public RequestContext configure( HttpServletRequest request, HttpServletResponse response, ApplicationContext applicationContext, String controllerName, Map args )
	{
		this.request = request;
		this.response = response;
		this.params = new RequestParameters( request );
		this.args = new OverridingMap( this.params, args );
		this.applicationContext = applicationContext;
		this.controllerName = controllerName;
		
		return this;
	}
	
	// Include
	public RequestContext configure( RequestContext parent, String controllerName, Map args )
	{
		this.request = parent.request;
		this.response = parent.response;
		this.params = parent.params;
		this.args = new OverridingMap( parent.args, args );
		this.applicationContext = parent.applicationContext;
		this.controllerName = controllerName;
		
		return this;
	}
	
	// Very important to get the writer when it is needed, otherwise you don't have the opportunity to set the charset in the ghtml
	public PrintWriter getOut()
	{
		if( this.out == null )
			try
			{
				this.out = this.response.getWriter();
			}
			catch( IOException e )
			{
				throw new SystemException( e );
			}
		return this.out;
	}
	
	public HttpSession getSession()
	{
		return this.request.getSession(); 
	}

	// TODO Merge fragments and args?
	public void include( Map args )
	{
		// TODO Only remove if they are the first in the map? It is a LinkedHashMap
		String page = Util.removeString( args, "page" );
		String controllerName = Util.removeString( args, "controller" );
		String actionName = Util.removeString( args, "action" );
		String url = Util.removeString( args, "url" );
		
		if( page != null )
		{
			log.debug( "include page [" + page + "]" );
			this.applicationContext.include( page, this, args );
		}
		else if( url != null )
		{
			log.debug( "include url [" + url + "]" );
			try
			{
				this.request.getRequestDispatcher( url ).include( this.request, this.response );
			}
			catch( ServletException e )
			{
				throw new SystemException( e );
			}
			catch( IOException e )
			{
				throw new SystemException( e );
			}
		}
		else
		{
			Assert.notNull( actionName != null, "Need 'action', 'page' or 'url'" );
			if( controllerName == null )
				controllerName = this.controllerName;
			Assert.notNull( controllerName != null, "Need a controller name for this" );
			log.debug( "include controller [" + controllerName + "], action [" + actionName + "]" );
			this.applicationContext.include( controllerName, actionName, this, args );
		}
	}

	public void include( Map args, Map extra )
	{
		args.putAll( extra );
		include( args );
	}

	public void forward( Map args )
	{
		// TODO Only remove if they are the first in the map? It is a LinkedHashMap
		String url = Util.removeString( args, "url" );
		
		Assert.notNull( url != null, "Need 'url'" );
		log.debug( "forward url [" + url + "]" );
		try
		{
			this.request.getRequestDispatcher( url ).forward( this.request, this.response );
		}
		catch( ServletException e )
		{
			throw new SystemException( e );
		}
		catch( IOException e )
		{
			throw new SystemException( e );
		}
	}

	public void withTemplate( Map args, Closure closure )
	{
		this.fragmentsCollector = new HashMap();
		closure.call();
		if( args == null ) args = new HashMap();
		args.putAll( this.fragmentsCollector ); // Fragments should override the args
		
		include( args );
	}

	// TODO Add possibility of params to a fragment?
	public void fragment( String name, Closure closure )
	{
		this.fragmentsCollector.put( name, closure ); 
	}
	
	public void includeFragment( String name )
	{
		Closure closure = (Closure)this.args.get( name );
		if( closure != null )
			closure.call();
	}

	public String encode( String s )
	{
		return Functions.escapeXml( s );
	}

	public String url( String url )
	{
		// Source: jakarta standard taglib 
		try
		{
			url = UrlSupport.resolveUrl( url, null, new PageContext( this.request ) );
		}
		catch( JspException e )
		{
			throw new SystemException( e );
		}
		if( !ImportSupport.isAbsoluteUrl( url ) )
            url = this.response.encodeURL( url );
		return url;
	}
	
	static public String encodeJSON( Object object )
	{
		if( object == null )
			return "";
		if( object instanceof String )
			return (String)object;
		if( object instanceof Number )
			return object.toString();
		return "(json)" + Util.encodeJSON( object );
	}
	
	static public Object decodeJSON( String string )
	{
		if( !string.startsWith( "(json)" ) )
			return string;
		string = string.substring( 6 );
		return Util.decodeJSON( string );
	}
	
	public String encodeURL( String string )
	{
		try
		{
			return URLEncoder.encode( string, "UTF-8" );
		}
		catch( UnsupportedEncodingException e )
		{
			throw new SystemException( e );
		}
	}

//	public String link()
//	{
//		return link( new HashMap() );
//	}
	
	public String link( Map< String, Object > args )
	{
		String controllerName = Util.removeString( args, "controller" );
		String actionName = Util.removeString( args, "action" );
		String pathInfo = Util.removeString( args, "pathInfo" );
		String url = Util.removeString( args, "url" );
		
		StringBuilder urlBuilder;
		
		if( url != null )
			urlBuilder = new StringBuilder( url );
		else
		{	if( controllerName == null )
				controllerName = this.controllerName;
			Assert.notNull( controllerName != null, "Need a controller name for this" );
			
			urlBuilder = new StringBuilder( this.request.getServletPath() );
			urlBuilder.append( '/' );
			urlBuilder.append( controllerName );
			if( actionName != null )
			{	urlBuilder.append( '/' );
				urlBuilder.append( actionName );
			}
			if( pathInfo != null )
			{	urlBuilder.append( '/' );
				urlBuilder.append( pathInfo );
			}
		}
		
		if( args != null )
		{	char c = '?';
			for( Map.Entry< String, Object > arg : args.entrySet() )
			{	urlBuilder.append( c );
				urlBuilder.append( encodeURL( arg.getKey().toString() ) );
				urlBuilder.append( '=' );
				urlBuilder.append( encodeURL( encodeJSON( arg.getValue() ) ) );
				c = '&';
			}
		}
		
		return url( urlBuilder.toString() );
	}
	
	public void redirect( Map args )
	{
		String url = link( args );
		try
		{
			this.response.sendRedirect( url );
		}
		catch( IOException e )
		{
			throw new SystemException( e );
		}
	}
	
	public void redirect( Map args, FlashKey key )
	{
		args.put( FLASHKEY, key.key );
		redirect( args );
	}
	
	public String getContentType()
	{
		String type = this.response.getContentType();
		if( type == null )
			return null;
		int pos = type.indexOf( ';' );
		if( pos >= 0 )
			return type.substring( 0, pos );
		return type;
	}
	
	// TODO Can we do it without this useless method call? Need to change the ghtml parsing for that
	public String autoEncode( String s ) { return s; }
	
	public String autoEncode( GString s )
	{
		if( xmlContentTypes.contains( getContentType() ) )
		{
			Object[] values = s.getValues();
			for( int i = values.length - 1; i >= 0; i-- )
			{	if( values[ i ] instanceof String )
					values[ i ] = Functions.escapeXml( (String)values[ i ] );
				else if( values[ i ] == null )
					values[ i ] = "";
				else if( values[ i ] instanceof GString )
					values[ i ] = Functions.escapeXml( values[ i ].toString() );
			}
			return s.toString();
		}
		
		Object[] values = s.getValues();
		for( int i = values.length - 1; i >= 0; i-- )
		{	if( values[ i ] == null )
				values[ i ] = "";
		}
		return s.toString();
	}

	public ApplicationContext getApplicationContext()
	{
		return this.applicationContext;
	}

	public void setApplicationContext( ApplicationContext applicationContext )
	{
		this.applicationContext = applicationContext;
	}
	
	public FlashKey flash( Map args )
	{
		HttpSession session = this.request.getSession();
		FlashCache cache = (FlashCache)session.getAttribute( GOSH_FLASHCACHE );
		if( cache == null )
		{
			cache = new FlashCache();
			session.setAttribute( GOSH_FLASHCACHE, cache );
		}
		return new FlashKey( cache.store( args ) );
	}
	
	public MarkupBuilder getXml()
	{
		return new MarkupBuilder( getOut() );
	}
	
	public String message( String key )
	{
		return this.applicationContext.getMessageSource().getMessage( key, null, null );
	}

	public String getControllerName()
	{
		return this.controllerName;
	}

	public HttpServletRequest getRequest()
	{
		return this.request;
	}

	public HttpServletResponse getResponse()
	{
		return this.response;
	}
	
//	public StateManager getState()
//	{
//		return new StateManager( getSession() );
//	}
}

class FlashKey
{
	String key;
	FlashKey( String key ) { this.key = key; }
}
