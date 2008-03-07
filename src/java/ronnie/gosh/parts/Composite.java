package ronnie.gosh.parts;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite extends Component
{
	protected List<Component> childs = new ArrayList();
	
	public Composite( Composite parent )
	{
		super( parent );
	}
	
	public void renderChilds()
	{
		for( Component child : this.childs )
			child.render();
	}
}
