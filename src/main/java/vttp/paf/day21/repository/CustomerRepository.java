package vttp.paf.day21.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

    public List<Customer> getCustomers() {
        final List<Customer> customers = new ArrayList<Customer>();
        SqlRowSet rs = template.queryForRowSet(sql.SQL_GET_ALL_CUSTOMERS);
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setFull_name(rs.getString("full_name"));
            customer.setEmail(rs.getString("email"));
            customers.add(customer);
        }

        return customers;
    }

    public List<Customer> getCustomersParams(int limit, int offset) {
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

    public Customer getCustomer(int id) {
        SqlRowSet rs = template.queryForRowSet(sql.SQL_GET_CUSTOMER_BY_ID, id);
        // next is need to move the cursor to the first row
        // also use for iteration through the rows
        if (rs.next()) { // Move the cursor to the first row
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setFull_name(rs.getString("full_name"));
            customer.setEmail(rs.getString("email"));
            return customer;
        } else {
            throw new RuntimeException("No customer found with ID: " + id);
        }
    }

    public Boolean deleteCustomer(int id) {
        int customerDeleted = template.update(sql.SQL_DELETE_CUSTOMER_BY_ID, id);
        if (customerDeleted > 0) {
            return true;
        }
        return false;
    }

    public Boolean updateCustomer(final int id,Customer customer) {
        int customerUpdated = template.update(sql.SQL_UPDATE_CUSTOMER_BY_ID,
                customer.getFull_name(), customer.getEmail(), id);

        if (customerUpdated > 0) {
            return true;
        }
        return false;
    }
}
