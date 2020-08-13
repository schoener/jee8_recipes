package de.javaee8recipes.cdi.injection.property;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PropertyReaderImpl implements PropertyReader {

	@Property
	@Inject
	private String value;

	public String getProperty() {
		return value;
	}

}
