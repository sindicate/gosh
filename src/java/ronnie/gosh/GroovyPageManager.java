package ronnie.gosh;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import groovy.lang.Closure;
import groovy.lang.GroovyObject;

import com.logicacmg.idt.commons.SystemException;
import com.logicacmg.idt.commons.util.Assert;


public class GroovyPageManager implements ResourceLoaderAware
{
	static final private Logger __LOGGER = Logger.getLogger( GroovyPageManager.class );
	
	protected ResourceLoader resourceLoader;
	protected String packag;
	protected String extension;
	protected String packageSlashed;
	protected boolean reloading;
	protected boolean precompiled;
	
	protected Map< String, CompiledGroovyPage > pages = new HashMap();

	public void setResourceLoader( ResourceLoader resourceLoader )
	{
		this.resourceLoader = resourceLoader;
	}
	
	public void setPackage( String packag )
	{
		this.packag = packag;
		this.packageSlashed = packag.replaceAll( "\\.", "/" );
	}
	
	public void setExtension( String extension )
	{
		this.extension = extension;
	}

	public void setPrecompiled( boolean precompiled )
	{
		this.precompiled = precompiled;
	}
	
	public void setReloading( boolean reloading )
	{
		__LOGGER.info( "Reloading = [" + reloading + "]" );
		this.reloading = reloading;
	}

	// TODO Cache in servletcontext or in our own applicationContext?
	public CompiledGroovyPage getPage( String path )
	{
		__LOGGER.debug( "getPage [" + path + "]" );

		Assert.isTrue( path.startsWith( "/" ) );

		if( this.precompiled )
		{
			CompiledGroovyPage page = this.pages.get( path );
			if( page != null )
				return page;
			
			try
			{
				String path2 = this.packag + path.replaceAll( "[\\.-]", "_" ).replaceAll( "/+", "." );
				__LOGGER.info( "Loading [" + path2 + "]" );

				Class pageClass = Class.forName( path2 );
				GroovyObject object = (GroovyObject)Util.newInstance( pageClass );
				page = new CompiledGroovyPage( (Closure)object.invokeMethod( "getClosure", null ), -1 );
				this.pages.put( path, page );
				return page;
			}
			catch( ClassNotFoundException e )
			{
				throw new SystemException( e );
			}
		}

		try
		{
			CompiledGroovyPage page = this.pages.get( path );
			
			Resource resource = null;
			long lastModified = 0;
			if( this.reloading || page == null )
			{
				String file = "/WEB-INF/classes/" + this.packageSlashed + path + ( this.extension != null ? this.extension : "" );
				resource = this.resourceLoader.getResource( file );
				lastModified = resource.getFile().lastModified(); // TODO LastModified does not work when packed in a war
				__LOGGER.debug( resource.getDescription() + ", lastModified: " + new Date( lastModified ) + " (" + lastModified + ")" );
			}
			
			if( this.reloading )
				if( page != null && page.lastModified > 0 )
					if( resource.exists() && lastModified > page.lastModified )
					{
						__LOGGER.info( resource.getDescription() + " changed, reloading" );
						page = null;
					}
			
			if( page == null )
			{
				if( !resource.exists() )
				{
					String error = resource.getDescription() + " not found";
					throw new PageNotFoundException( error );
				}
				
				__LOGGER.info( "Loading " + resource.getDescription() );

				Reader reader = new InputStreamReader( resource.getInputStream() );
				page = GroovyPageCompiler.compile( reader, this.packageSlashed + path, lastModified );
				
				this.pages.put( path, page );
			}
			
			return page;
		}
		catch( IOException e )
		{
			throw new SystemException( e );
		}
	}
}
