public class Clone399 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:3320400
*  Stack Overflow answer #:15816247
*  And Stack Overflow answer#:7820092
*/
public void contextDestroyed (ServletContextEvent servletContextEvent) {
    if (this.driver != null) {
        try {
            DriverManager.deregisterDriver (driver);
            LOG.info (String.format ("deregistering jdbc driver: %s", driver));
        } catch (SQLException e) {
            LOG.warn (String.format ("Error deregistering driver %s", driver), e);
        }
        this.driver = null;
    } else {
        LOG.warn ("No driver to deregister");
    }
}

public void contextDestroyed (ServletContextEvent sce) {
    Context initContext = new InitialContext ();
    Context envContext = (Context) initContext.lookup ("java:/comp/env");
    DataSource datasource = (DataSource) envContext.lookup ("jdbc/database");
    try {
        java.sql.Driver mySqlDriver = DriverManager.getDriver ("jdbc:mysql://localhost:3306/");
        DriverManager.deregisterDriver (mySqlDriver);
    } catch (SQLException ex) {
        logger.info ("Could not deregister driver:".concat (ex.getMessage ()));
    }
    dataSource = null;
}

}
