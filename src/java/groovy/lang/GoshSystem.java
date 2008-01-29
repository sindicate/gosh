package groovy.lang;

import org.apache.log4j.Logger;

public class GoshSystem
{
	static public Logger getLogger( Class cls )
	{
		return Logger.getLogger( cls );
	}
}
