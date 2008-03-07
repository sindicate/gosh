package ronnie.gosh.parts;

import ronnie.gosh.RequestContext;

public interface Form
{
	void init();
	void call( RequestContext context );
}
