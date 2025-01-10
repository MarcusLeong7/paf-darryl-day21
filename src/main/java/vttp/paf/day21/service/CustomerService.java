package vttp.paf.day21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vttp.paf.day21.model.Customer;
import vttp.paf.day21.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    public List<Customer> getAllCustomers() {
        return customerRepo.getCustomers();
    }

    public List<Customer> getAllCustomersParams(int limit, int offset) {
      return customerRepo.getCustomersParams(limit,offset);
    }

    public Customer getCustomer(int id) {
        return customerRepo.getCustomerById(id);
    }

    public Boolean deleteCustomer(int id) {
        return customerRepo.deleteCustomer(id);
    }

    public Boolean updateCustomer(int id,Customer customer) {
        return customerRepo.updateCustomer(id,customer);
    }

    public Boolean insertCustomer(Customer customer) {
        return customerRepo.insertNewCustomer(customer);
    }
}
