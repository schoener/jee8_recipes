package de.javaee8recipes.cdi.producer.with.alternative.producer;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.literal.NamedLiteral;

import de.javaee8recipes.cdi.producer.with.alternative.Printable;

public class PrinterProducer {

	private Instance<Printable> printables;
	
	public Printable providePrintableInstance() {
		return printables.select(NamedLiteral.of("laserPrinter")).get();
	}
}
