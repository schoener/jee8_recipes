package de.javaee8recipes.cdi.injection.explicit.bean.ejb;

import javax.ejb.EJB;

@EJB
public class EJBBeanImpl implements EJBBean {

	public String getMessage() {
		return "Yahoo this is a message from EJB Bean";
	}

}
