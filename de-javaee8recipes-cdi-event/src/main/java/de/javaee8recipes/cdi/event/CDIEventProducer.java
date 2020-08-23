package de.javaee8recipes.cdi.event;

import java.io.Serializable;

public interface CDIEventProducer extends Serializable {

	void fireEvent(String eventType);

}
