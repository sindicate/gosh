package ronnie.gosh.parts;

import groovy.lang.GroovyObject;
import ronnie.gosh.RequestContext;

public interface Screen extends GroovyObject
{
	void init( RequestContext context );
	void call( RequestContext context );
}
