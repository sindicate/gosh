package ronnie.gosh.parts;

import java.util.HashMap;
import java.util.Map;

public class ScreenManager
{
	protected Map<String, Screen> screens = new HashMap();
	
	public Screen getScreen( String name )
	{
		return this.screens.get( name );
	}

	public void storeScreen( String name, Screen screen )
	{
		this.screens.put( name, screen );
	}

	public void clearScreen( String name )
	{
		this.screens.remove( name );
	}
}
