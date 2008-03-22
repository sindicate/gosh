package ronnie.gosh.parts;

import ronnie.gosh.RequestContext;

public interface Screen
{
	enum CANACCEPT { YES, NEW }
	
	void setName( String name );
	CANACCEPT canAccept( RequestContext context );
	void init( RequestContext context );
	void call( RequestContext context );
}
