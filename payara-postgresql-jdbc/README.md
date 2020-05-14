# PostgreSQL Payara setup and usage

* cp 42.2.12.jre7/postgresql-42.2.12.jre7.jar ~/servers/payara5_full/payara5/glassfish/lib/.
* start/stop/status for postgresql can be found [here](https://wiki.ubuntuusers.de/PostgreSQL/) in german
* installed pgadmin3 which cann be started with `pgadmin3`

Use JNDI to connect to database:

```
	public static Connection getDbConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("jdbc/__PostgresqlPool");
			conn = ds.getConnection();
		} catch (NamingException | SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
```

The payara domain.xml should be adjusted as below or check the [page](https://blog.payara.fish/an-intro-to-connection-pools-in-payara-server-5)

```
  <resources>
   <jdbc-connection-pool datasource-classname="org.postgresql.ds.PGSimpleDataSource" name="PostgresqlPool" res-type="javax.sql.DataSource">
      <property name="URL" value="jdbc:postgresql://localhost:5432/postgres"></property>
      <property name="password" value="******"></property>
      <property name="user" value="postgres"></property>
    </jdbc-connection-pool>
    <jdbc-resource pool-name="PostgresqlPool" jndi-name="jdbc/__PostgresqlPool"></jdbc-resource>
  </resources>
  <servers>
    <server config-ref="server-config" name="server">
      <resource-ref ref="jdbc/__PostgresqlPool"></resource-ref>
    </server>
  </servers>
```