# Persistence unit integration with JNDA resource

* defined the persistence.xml in META-INF folder
* transaction-type attribute of a persistence unit indicates whether Java Transaction API entity managers will be created 
(for use within an application server) or Resource-Local entity managers will be created (for use with stand-alone applications) 
* in fact the transaction-type attribute could be JTA or RESOURCE_LOCAL

The main part for persistence.xml is defined below

```
	<persistence-unit name="PersistenceUnitJNDI"
		transaction-type="JTA">
		<jta-data-source>jdbc/__PostgresqlPool</jta-data-source>
	</persistence-unit>
```

The place where the persistence.xml have to be located is defined [here](https://docs.oracle.com/cd/E19798-01/821-1841/bnbrj/index.html).
Since this project is packed into a WAR file and the compiled classes are not packed in a JAR the persistence file is located in src/main/resources/META-INF/persistence.xml

