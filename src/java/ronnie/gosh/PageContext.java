package ronnie.gosh;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.el.ExpressionEvaluator;
import javax.servlet.jsp.el.VariableResolver;

import com.logicacmg.idt.commons.NotImplementedException;

public class PageContext extends javax.servlet.jsp.PageContext
{
	protected ServletRequest request;
	
	public PageContext( ServletRequest request )
	{
		this.request = request;
	}

	@Override
	public void forward( String arg0 ) throws ServletException, IOException
	{
		throw new NotImplementedException();
	}

	@Override
	public Exception getException()
	{
		throw new NotImplementedException();
	}

	@Override
	public Object getPage()
	{
		throw new NotImplementedException();
	}

	@Override
	public ServletRequest getRequest()
	{
		return this.request;
	}

	@Override
	public ServletResponse getResponse()
	{
		throw new NotImplementedException();
	}

	@Override
	public ServletConfig getServletConfig()
	{
		throw new NotImplementedException();
	}

	@Override
	public ServletContext getServletContext()
	{
		throw new NotImplementedException();
	}

	@Override
	public HttpSession getSession()
	{
		throw new NotImplementedException();
	}

	@Override
	public void handlePageException( Exception arg0 ) throws ServletException, IOException
	{
		throw new NotImplementedException();
	}

	@Override
	public void handlePageException( Throwable arg0 ) throws ServletException, IOException
	{
		throw new NotImplementedException();
	}

	@Override
	public void include( String arg0 ) throws ServletException, IOException
	{
		throw new NotImplementedException();
	}

	@Override
	public void include( String arg0, boolean arg1 ) throws ServletException, IOException
	{
		throw new NotImplementedException();
	}

	@Override
	public void initialize( Servlet arg0, ServletRequest arg1, ServletResponse arg2, String arg3, boolean arg4,
			int arg5, boolean arg6 ) throws IOException, IllegalStateException, IllegalArgumentException
	{
		throw new NotImplementedException();
	}

	@Override
	public void release()
	{
		throw new NotImplementedException();
	}

	@Override
	public Object findAttribute( String arg0 )
	{
		throw new NotImplementedException();
	}

	@Override
	public Object getAttribute( String arg0 )
	{
		throw new NotImplementedException();
	}

	@Override
	public Object getAttribute( String arg0, int arg1 )
	{
		throw new NotImplementedException();
	}

	@Override
	public Enumeration getAttributeNamesInScope( int arg0 )
	{
		throw new NotImplementedException();
	}

	@Override
	public int getAttributesScope( String arg0 )
	{
		throw new NotImplementedException();
	}

	@Override
	public ExpressionEvaluator getExpressionEvaluator()
	{
		throw new NotImplementedException();
	}

	@Override
	public JspWriter getOut()
	{
		throw new NotImplementedException();
	}

	@Override
	public VariableResolver getVariableResolver()
	{
		throw new NotImplementedException();
	}

	@Override
	public void removeAttribute( String arg0 )
	{
		throw new NotImplementedException();
	}

	@Override
	public void removeAttribute( String arg0, int arg1 )
	{
		throw new NotImplementedException();
	}

	@Override
	public void setAttribute( String arg0, Object arg1 )
	{
		throw new NotImplementedException();
	}

	@Override
	public void setAttribute( String arg0, Object arg1, int arg2 )
	{
		throw new NotImplementedException();
	}
}
