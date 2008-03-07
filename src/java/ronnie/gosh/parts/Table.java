package ronnie.gosh.parts;

import java.util.ArrayList;
import java.util.List;

public class Table extends Component
{
	protected List< Column > columns;
	
	public Table( Composite parent )
	{
		super( parent );
		this.columns = new ArrayList();
	}
	
	@Override
	public void render()
	{
		getOut().println( "Hello World! from Table" );
	}

	public void addColumn( Column column )
	{
		this.columns.add( column );
	}
	
	static public class Column
	{
		protected String data;
		protected String header;
	}
}
