package de.javaee8recipes.cdi.injection.property.resourcebundle.producer;

import java.io.InputStream;
import java.util.Properties;
import java.util.function.Function;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;

@ApplicationScoped
public class PropertyProducer {

	@Produces
	@Property
	public String produceConfigurationValueForString(InjectionPoint injectionPoint) {
		String propertyValue = getProperty(injectionPoint, String::valueOf, "");
		return propertyValue;
	}

	@Produces
	@Property
	public Double produceConfigurationValueForDouble(InjectionPoint injectionPoint) {
		Double propertyValue = getProperty(injectionPoint, Double::valueOf, Double.valueOf(0));
		return propertyValue;
	}

	private <T> T getProperty(InjectionPoint injectionPoint, Function<String, T> function, T defaultValue) {
		T propertyValue = defaultValue;
		Annotated annotated = injectionPoint.getAnnotated();
		Property annotation = annotated.getAnnotation(Property.class);
		if (annotation != null) {
			Properties props = loadPropertiesFromResource();
			String value = (String) props.get(annotation.key());
			if (value != null) {
				propertyValue = function.apply(value);
			}
		}
		return propertyValue;
	}

	private Properties loadPropertiesFromResource() {
		Properties props = new Properties();
		try {
			InputStream propertyInputStream = PropertyProducer.class.getClassLoader().getResourceAsStream("config/myconf.properties");
			props.load(propertyInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
	}
}
