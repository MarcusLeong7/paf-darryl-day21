package vttp.paf.day21.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import vttp.paf.day21.model.Customer;
import vttp.paf.day21.utils.sql;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate template;

    public List<Customer> getCustomers(final int limit, final int offset) {
        final List<Customer> customers = new ArrayList<Customer>();
        SqlRowSet rs = template.queryForRowSet(sql.SQL_GET_ALL_CUSTOMERS_LIMIT_OFFSET, limit, offset);
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setFull_name(rs.getString("full_name"));
            customer.setEmail(rs.getString("email"));
            customers.add(customer);
        }

        return customers;
    }
}
