package br.com.codecompany.rysys.core.cache;

import br.com.codecompany.rysys.core.jmx.AbstractProbingAspect;

public aspect Precedence {
	// ordem que os aspectos interceptarao o codigo
	declare precedence : AbstractCachingAspect, AbstractProbingAspect;
}
