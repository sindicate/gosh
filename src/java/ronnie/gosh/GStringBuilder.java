package ronnie.gosh;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.groovy.runtime.GStringImpl;

import groovy.lang.GString;

import com.logicacmg.idt.commons.util.Assert;

public class GStringBuilder
{
	protected List< String > strings = new ArrayList();
	protected List< Object > values = new ArrayList();
	
	public GStringBuilder append( GString s )
	{
		Assert.isTrue( this.strings.size() == 0 || this.strings.size() == this.values.size() + 1 );

		String[] strings = s.getStrings();
		Object[] values = s.getValues();
		Assert.isTrue( strings.length == values.length + 1 );

		append( strings[ 0 ] );
		
		for( int i = 0; i < values.length; i++ )
			this.values.add( values[ i ] );
		for( int i = 1; i < strings.length; i++ )
			this.strings.add( strings[ i ] );
		
		Assert.isTrue( this.strings.size() == this.values.size() + 1 );
		return this;
	}
	
	public GStringBuilder append( String s )
	{
		Assert.isTrue( this.strings.size() == 0 || this.strings.size() == this.values.size() + 1 );
		
		int last = this.strings.size() - 1;
		if( last >= 0 )
			this.strings.set( last, this.strings.get( last ) + s );
		else
			this.strings.add( s );
		
		Assert.isTrue( this.strings.size() == this.values.size() + 1 );
		return this;
	}
	
	public GStringBuilder append( Object o )
	{
		return append( o.toString() );
	}
	
	public GString toGString()
	{
		int size = this.values.size();
		Assert.isTrue( this.strings.size() == size + 1 );
		return new GStringImpl( this.values.toArray( new Object[ size ] ), this.strings.toArray( new String[ size + 1 ] ) );
	}
}
