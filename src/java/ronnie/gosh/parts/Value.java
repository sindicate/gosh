package ronnie.gosh.parts;

import java.util.List;

import commonj.sdo.DataObject;


public class Value
{
	protected String path;
	protected String description;
	protected boolean edit;
	protected Select select;
	protected List< DataObject > selectData;
	protected boolean mandatory;
	protected boolean checkbox; // TODO Change to type, inherit from SDO\
	protected Integer size;
}
