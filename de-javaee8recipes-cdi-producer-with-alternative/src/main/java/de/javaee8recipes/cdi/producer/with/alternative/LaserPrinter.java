package de.javaee8recipes.cdi.producer.with.alternative;

import javax.inject.Named;

@Named("laserPrinter")
public class LaserPrinter implements Printable {

	@Override
	public void print() {
		System.out.println(this.getClass().getName() + " wants to print");
	}
}
