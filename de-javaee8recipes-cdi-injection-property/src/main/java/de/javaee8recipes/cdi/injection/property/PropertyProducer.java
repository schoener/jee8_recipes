package de.javaee8recipes.cdi.injection.property;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class PropertyProducer {

	@Property
	@Produces
	private String value = "value initialized";

}
