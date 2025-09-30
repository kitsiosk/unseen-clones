public class Clone328 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:4508172
*  Stack Overflow answer #:8899593
*  And Stack Overflow answer#:26997723
*/
public static void close (Connection connection, Statement statement, ResultSet rs) {
    if (rs != null) {
        try {
            rs.close ();
        } catch (Exception e) {
            _logger.warning (e.toString ());
        }
    }
    if (statement != null) {
        try {
            statement.close ();
        } catch (Exception e) {
            _logger.warning (e.toString ());
        }
    }
    if (connection != null) {
        try {
            connection.close ();
        } catch (Exception e) {
            _logger.warning (e.toString ());
        }
    }
}

public static void close (Statement...statements) {
    for (Statement stmt : statements) {
        try {
            if (stmt != null) stmt.close ();
        } catch (SQLException se) {
        }
    }
}

}
