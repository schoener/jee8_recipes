package de.javaee8recipes.cdi.injection.implicit.bean.archive.stereotype;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.inject.Stereotype;

@Retention(RUNTIME)
@Target({ TYPE, METHOD })
@Stereotype
public @interface CustomCDI {

}
