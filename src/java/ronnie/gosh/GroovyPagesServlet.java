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

public class GroovyPagesServlet extends HttpServlet
{
//	static final private int BUFFER_SIZE = 8192;
	static final private Logger __LOGGER = Logger.getLogger( GroovyPagesServlet.class );
	
	protected WebApplicationContext webApplicationContext;
	protected ApplicationContext applicationContext;
	
	@Override
	public void init() throws ServletException
	{
		WebApplicationContext parent = WebApplicationContextUtils.getRequiredWebApplicationContext( getServletContext() );

		String context = getServletName() + "-context";
		__LOGGER.info( "Reading [/WEB-INF/" + context + ".xml]" );

		ConfigurableWebApplicationContext wac = new XmlWebApplicationContext();
		wac.setParent( parent );
		wac.setServletContext( getServletContext() );
		wac.setServletConfig( getServletConfig() );
		wac.setNamespace( context );
		wac.refresh();

		this.webApplicationContext = wac;
		
		this.applicationContext = (ApplicationContext)wac.getBean( "applicationContext" );
}

	@Override
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
	{
		String servletPath = request.getServletPath();
		this.applicationContext.call( servletPath, request, response );
	}
}
