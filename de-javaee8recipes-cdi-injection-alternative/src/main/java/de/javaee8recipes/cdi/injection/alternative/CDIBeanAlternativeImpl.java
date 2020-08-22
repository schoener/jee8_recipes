package de.javaee8recipes.cdi.injection.alternative;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

@RequestScoped
@Alternative
public class CDIBeanAlternativeImpl implements CDIBean {

	public String getMessage() {
		return this.getClass().getSimpleName();
	}

}
