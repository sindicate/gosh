package ronnie.gosh;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.logicacmg.idt.commons.SystemException;
import com.logicacmg.idt.commons.servlet.HttpUtil;

public class GoshDispatcherServlet extends HttpServlet
{
	static final private Logger log = Logger.getLogger( GoshDispatcherServlet.class );
	
	protected WebApplicationContext webApplicationContext;
	protected ApplicationContext applicationContext;
	
	protected boolean useActionNames;
	
	@Override
	public void init() throws ServletException
	{
		WebApplicationContext parent = WebApplicationContextUtils.getRequiredWebApplicationContext( getServletContext() );

		String context = getServletName() + "-context";
		log.info( "Reading [/WEB-INF/" + context + ".xml]" );

		ConfigurableWebApplicationContext wac = new XmlWebApplicationContext();
		wac.setParent( parent );
		wac.setServletContext( getServletContext() );
		wac.setServletConfig( getServletConfig() );
		wac.setNamespace( context );
		wac.refresh();

		this.webApplicationContext = wac;
		
		this.applicationContext = (ApplicationContext)wac.getBean( "applicationContext" );
		
		this.useActionNames = true;
	}
	
	protected String resolveActionName( HttpServletRequest request, String urlActionName )
	{
		return urlActionName;
	}
	
	static final private Pattern pathInfoPattern1 = Pattern.compile( "/([^\\/]+)/?([^\\/]+)?/?(.+)?" );
	static final private Pattern pathInfoPattern2 = Pattern.compile( "/([^\\/]+)/?(.+)?" );
	
	protected ResolvedRequest resolveRequest( HttpServletRequest request )
	{
		String pathInfo = request.getPathInfo();
		if( pathInfo == null )
			return null;
		
		Matcher matcher = this.useActionNames ? pathInfoPattern1.matcher( pathInfo ) : pathInfoPattern2.matcher( pathInfo ); 
		if( !matcher.matches() )
			return null;
		
		String controllerName = matcher.group( 1 );
		String actionName = this.useActionNames ? resolveActionName( request, matcher.group( 2 ) ) : null;
		String pathInfoRest = matcher.group( this.useActionNames ? 3 : 2 );
		
		return new ResolvedRequest( controllerName, actionName, pathInfoRest );
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	protected void doService( HttpServletRequest request, HttpServletResponse response ) throws IOException
	{
		ResolvedRequest resolved = resolveRequest( request );
		if( resolved == null )
		{
			response.sendError( HttpServletResponse.SC_NOT_FOUND, request.getRequestURI() );
			return;
		}
		
		try
		{
			this.applicationContext.call( resolved, request, response );
		}
		catch( RequestedResourceNotAvailableException e )
		{
			log.error( "", e );
			response.sendError( HttpServletResponse.SC_NOT_FOUND, request.getRequestURI() );
		}
	}

	@Override
	protected void service( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		try
		{
			HttpUtil.logRequest( log, request );
			doService( request, response );
			HttpUtil.logResponse( log, response );
		}
		catch( Exception e )
		{
			log.debug( "", e );
			Util.transformToGroovy( e );
			log.error( "", e );
			if( e instanceof ServletException )
				throw (ServletException)e;
			if( e instanceof IOException )
				throw (IOException)e;
			if( e instanceof RuntimeException )
				throw (RuntimeException)e;
			throw new SystemException( e );
		}
		catch( Error e )
		{
			log.debug( "", e );
			Util.transformToGroovy( e );
			log.error( "", e );
			throw e;
		}
	}
	
	static public class ResolvedRequest
	{
		protected String controllerName;
		protected String actionName;
		protected String pathInfo;
		public ResolvedRequest( String controllerName, String actionName, String pathInfoRest )
		{
			this.controllerName = controllerName;
			this.actionName = actionName;
			this.pathInfo = pathInfoRest;
		}
	}
}
