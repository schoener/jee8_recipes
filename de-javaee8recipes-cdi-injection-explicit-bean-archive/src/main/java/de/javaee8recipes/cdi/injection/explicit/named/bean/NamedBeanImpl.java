package de.javaee8recipes.cdi.injection.explicit.named.bean;

import javax.inject.Named;

@Named
public class NamedBeanImpl implements NamedBean {

	public String getMessage() {
		return "Yahoo this is a message from Named Bean";
	}

}
