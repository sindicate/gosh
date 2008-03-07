package ronnie.gosh.parts;

import ronnie.gosh.RequestContext;

public interface Screen
{
	void init();
	void call( RequestContext context );
}
