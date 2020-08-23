package de.javaee8recipes.cdi.event;

import java.time.LocalDate;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import de.javaee8recipes.cdi.event.type.CDIEvent;
import de.javaee8recipes.cdi.event.type.Credit;
import de.javaee8recipes.cdi.event.type.Debit;

@SessionScoped
public class CDIEventProducerImpl implements CDIEventProducer {
	private static final long serialVersionUID = 1L;

	@Inject
	@Debit
	private Event<CDIEvent> debitEvent;

	@Inject
	@Credit
	private Event<CDIEvent> creditEvent;

	@Override
	public void fireEvent(String eventType) {
		switch (eventType) {
		case "debit":
			debitEvent.fire(new CDIEvent("action", LocalDate.now()));
			break;
		case "credit":
			creditEvent.fire(new CDIEvent("action", LocalDate.now().plusDays(1)));
			break;
		default:
			throw new IllegalArgumentException("wrong event type " + eventType);
		}
	}

}
