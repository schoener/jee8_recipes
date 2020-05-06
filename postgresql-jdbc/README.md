# Simple PostgreSQL Implementation
This is a simple html servlet which integrates PostgreSQL. Connection to database will be opened the the current database version will be displayed on the page.

* `Class.forName("org.postgresql.Driver")` is required since we need to [load](https://stackoverflow.com/questions/8053095/what-is-the-actual-use-of-class-fornameoracle-jdbc-driver-oracledriver-while) the particular driver.

* The pattern for PostgreSQL url can be checked [here](https://jdbc.postgresql.org/documentation/head/connect.html).