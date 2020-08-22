package de.javaee8recipes.cdi.injection.alternative;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CDIBeanImpl implements CDIBean {

	public String getMessage() {
		return this.getClass().getSimpleName();
	}

}
