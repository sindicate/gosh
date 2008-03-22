package ronnie.gosh.parts;

import ronnie.gosh.RequestContext;

public interface Screen
{
	void init( RequestContext context );
	void call( RequestContext context );
}
