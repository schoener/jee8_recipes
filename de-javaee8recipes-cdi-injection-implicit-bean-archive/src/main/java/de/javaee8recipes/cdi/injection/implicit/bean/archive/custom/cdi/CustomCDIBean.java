package de.javaee8recipes.cdi.injection.implicit.bean.archive.custom.cdi;

import de.javaee8recipes.cdi.injection.implicit.bean.CDIBean;
import de.javaee8recipes.cdi.injection.implicit.bean.archive.stereotype.CustomCDI;

@CustomCDI
public class CustomCDIBean implements CDIBean {

	public String getMessage() {
		return "Yahoo this is a message from Custom CDI Bean";
	}

}
