public class Clone920 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:31158509
*  Stack Overflow answer #:31180058
*  And Stack Overflow answer#:50564556
*/
public Serializable generate (SessionImplementor session, Object object) throws HibernateException {
    String prefix = "DEP";
    Connection connection = session.connection ();
    try {
        Statement statement = connection.createStatement ();
        ResultSet rs = statement.executeQuery ("select count(Department_Id) as Id from demo.Department");
        if (rs.next ()) {
            int id = rs.getInt (1) + 101;
            String generatedId = prefix + new Integer (id).toString ();
            System.out.println ("Generated Id: " + generatedId);
            return generatedId;
        }
    } catch (SQLException e) {
        e.printStackTrace ();
    }
    return null;
}

public Serializable generate (SessionImplementor session, Object object) throws HibernateException {
    Serializable result = null;
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    String prefix = "emp";
    try {
        connection = session.connection ();
        statement = connection.createStatement ();
        try {
            resultSet = statement.executeQuery ("SELECT next_val FROM  " + DEFAULT_SEQUENCE_NAME);
        } catch (Exception e) {
            System.out.println ("In catch, cause : Table is not available.");
            statement.execute ("CREATE table " + DEFAULT_SEQUENCE_NAME + " (next_val INT NOT NULL)");
            statement.executeUpdate ("INSERT INTO " + DEFAULT_SEQUENCE_NAME + " VALUES(0)");
            statement.executeUpdate ("UPDATE " + DEFAULT_SEQUENCE_NAME + " SET next_val=LAST_INSERT_ID(next_val+1)");
            resultSet = statement.executeQuery ("SELECT next_val FROM  " + DEFAULT_SEQUENCE_NAME);
        }
        if (resultSet.next ()) {
            int nextValue = resultSet.getInt (1);
            String suffix = String.format ("%04d", nextValue);
            result = prefix.concat (suffix);
            System.out.println ("Custom generated sequence is : " + result);
        }
    } catch (SQLException e) {
        e.printStackTrace ();
    }
    return result;
}

}
