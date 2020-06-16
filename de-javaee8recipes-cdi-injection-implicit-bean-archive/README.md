# Implicit bean archive

In project `de-javaee8recipes-cdi-injection-implicit-bean-archive` implicit bean archive is defined which means the META_INF/beans.xml file is missing. The CDI bean is annotated with bean defining annotation - in this case `@RequestScoped`.

If not beans.xml is present (or the bean-discovery-mode is set to annotated) then only classes with a [Bean Defining Annotation](https://docs.jboss.org/cdi/spec/2.0-PFD2/cdi-spec.html#bean_defining_annotationsIf) are picked up. 


# Implicit bean archive with stereotype annotation

`@CustomCDI` annotation was introduced to test the stereotype annotation process. 