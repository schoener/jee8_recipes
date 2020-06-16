package de.javaee8recipes.cdi.injection.implicit.bean.archive;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CDIBeanImpl implements CDIBean {

	public String getMessage() {
		return "Yahoo this is a message from CDI Bean";
	}

}
