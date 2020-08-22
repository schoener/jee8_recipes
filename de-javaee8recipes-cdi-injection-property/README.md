# Property injection 

In project `de-javaee8recipes-cdi-injection-property` I have introduced an annotation `@Property` which will be used to provide property injection. The producer class contains a member field which will be annotated with `@Produces` and with the new introduced `@Property` annotations. The consumer - in this case the bean just inject the field. Besides the field must be annotated with `@Property` annotation. 