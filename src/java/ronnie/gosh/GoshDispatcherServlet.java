package ronnie.gosh;

import java.io.IOException;

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

public class GoshDispatcherServlet extends HttpServlet
{
	static final private Logger log = Logger.getLogger( GoshDispatcherServlet.class );
	
	protected String defaultRequestEncoding = "UTF-8";
	
	protected WebApplicationContext webApplicationContext;
	protected ApplicationContext applicationContext;
	
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
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	protected void doService( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		this.applicationContext.call( request, response );
	}

	@Override
	protected void service( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		if( request.getCharacterEncoding() == null )
			request.setCharacterEncoding( this.defaultRequestEncoding );
		
		try
		{
			doService( request, response );
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
}
