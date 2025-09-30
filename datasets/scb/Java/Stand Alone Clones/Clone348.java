public class Clone348 {
/*
* Semantic clone benchmark
*  Source code are extracted from Stack Overflow
*  Stack overflow Question #:13295600
*  Stack Overflow answer #:13599470
*  And Stack Overflow answer#:13599470
*/
public void processRow (ResultSet rs) throws SQLException {
    Long id = rs.getLong ("CUSTOMER_ID");
    Customer customer = map.get (id);
    if (customer == null) {
        customer = new Customer ();
        customer.setId (id);
        customer.setName (rs.getString ("CUSTOMER_NAME"));
        customer.setAccountNumber (rs.getLong ("CUSTOMER_ACCOUNT_NO"));
        map.put (id, customer);
    }
}

public void processRow (ResultSet rs) throws SQLException {
    Long id = rs.getLong ("CUSTOMER_ID");
    Customer customer = map.get (id);
    if (customer != null) {
        List ordersList = customer.getOrders ();
        if (ordersList == null) {
            ordersList = new ArrayList < Order > ();
            customer.setOrders (ordersList);
        }
        Order order = new Order ();
        order.setId (rs.getLong ("ORDER_ID"));
        ordersList.add (order);
    }
}

}
