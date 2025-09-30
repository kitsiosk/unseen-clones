public class Clone347 {
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
        List brandList = customer.getBrands ();
        if (brandsList == null) {
            brandsList = new ArrayList < Brand > ();
            customer.setBrands (brandsList);
        }
        Brand brand = new Brand ();
        brand.setId (rs.getLong ("CUSTOMER_BRAND_ID"));
        brand.setName (rs.getString ("CUSTOMER_BRAND_NAME"));
        brandsList.add (brand);
    }
}

}
