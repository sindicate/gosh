package ronnie.gosh;

import com.logicacmg.idt.commons.VersionSupport;

/**
 * 
 * 
 * @author R.M. de Bloois
 */
public class Version
{
	static String version;
	
	static public String getVersion()
	{
		if( version == null )
			version = VersionSupport.getVersion( Version.class );
		return version;
	}
}
