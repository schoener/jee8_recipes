# EJB/Persistence unit integration with JNDA resource

In project `de-javaee8recipes-persistenceunit-ejb` I have created a EJB class which does a query to DB and returns the version of database. CMT (container managed transaction) will be used here. The EJB access the database through entity manager which can be injected:

```
 @PersistenceContext(unitName = "PersistenceUnitJNDI")
 private EntityManager em;

```

This EJB is injected in servlet class which is located in project `de-javaee8recipes-persistenceunit-web`.