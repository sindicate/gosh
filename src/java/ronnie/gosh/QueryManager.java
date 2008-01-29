package ronnie.gosh;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

import com.logicacmg.idt.commons.SystemException;
import com.logicacmg.idt.commons.util.Assert;


// TODO Change detection
public class QueryManager implements ApplicationContextAware
{
	static final private Logger __LOGGER = Logger.getLogger( QueryManager.class );
	
	protected ApplicationContext applicationContext;
	protected String packag;
	protected String packageSlashed;
	protected boolean reloading;
	protected Map< String, CompiledQuery > queries = new HashMap();

	public void setApplicationContext( ApplicationContext context )
	{
		this.applicationContext = context;
	}

	public void setPackage( String packag )
	{
		this.packag = packag;
		this.packageSlashed = packag.replaceAll( "\\.", "/" );
	}
	
	public void setReloading( boolean reloading )
	{
		__LOGGER.info( "Reloading = [" + reloading + "]" );
		this.reloading = reloading;
	}

	public CompiledQuery getQuery( String path )
	{
		__LOGGER.debug( "getQuery [" + path + "]" );
		
		Assert.isTrue( path.startsWith( "/" ) );

		try
		{
			CompiledQuery query = this.queries.get( path );
			
			Resource resource = null;
			long lastModified = 0;
			if( this.reloading || query == null )
			{
				String file = "/WEB-INF/classes/" + this.packageSlashed + path + ".gsql";
				resource = this.applicationContext.getResource( file );
				lastModified = resource.getFile().lastModified(); // TODO LastModified does not work when packed in a war
				__LOGGER.debug( resource.getDescription() + ", lastModified: " + new Date( lastModified ) + " (" + lastModified + ")" );
			}
			
			if( this.reloading )
				if( query != null && query.lastModified > 0 )
					if( resource.exists() && lastModified > query.lastModified )
					{
						__LOGGER.info( resource.getDescription() + " changed, reloading" );
						query = null;
					}

			if( query == null )
			{
				if( !resource.exists() )
				{
					String error = resource.getDescription() + " not found";
					throw new QueryNotFoundException( error );
				}
				
				__LOGGER.info( "Loading " + resource.getDescription() );

				Reader reader = new InputStreamReader( resource.getInputStream() ); // TODO Character set
				query = QueryCompiler.compile( reader, this.packageSlashed + path, lastModified );
				
				this.queries.put( path, query );
			}

			return query;
		}
		catch( IOException e )
		{
			throw new SystemException( e );
		}
	}
	
//	public Query getQuery( String path, Map args )
//	{
//		CompiledQuery query = getQuery( path );
//		return query.params( args );
//	}
}
