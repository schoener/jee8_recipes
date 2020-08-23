package de.javaee8recipes.cdi.event;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;

import de.javaee8recipes.cdi.event.type.CDIEvent;
import de.javaee8recipes.cdi.event.type.Credit;
import de.javaee8recipes.cdi.event.type.Debit;

@SessionScoped
public class EventListener implements Serializable {
	private static final long serialVersionUID = 1L;

	public void listenForDebitEvent(@Observes @Debit CDIEvent event) {
		System.out.println("receives debit event " + event);
	}

	public void listenForCreditEvent(@Observes @Credit CDIEvent event) {
		System.out.println("receives credit event " + event);
	}
}
