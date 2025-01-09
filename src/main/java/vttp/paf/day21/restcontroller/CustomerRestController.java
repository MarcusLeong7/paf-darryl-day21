package vttp.paf.day21.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vttp.paf.day21.model.Customer;
import vttp.paf.day21.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerSvc;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = customerSvc.getAllCustomers();
        return ResponseEntity.ok().body(customers);
    }
    // Query params limit and offset
    // http://localhost:8080/api/customers/limit?limit=2&offset=1
    @GetMapping("/limit")
    public ResponseEntity<List<Customer>> getAllCustomerParams(@RequestParam int limit,
                                                         @RequestParam int offset) {
        List<Customer> customers = customerSvc.getAllCustomersParams(limit, offset);
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/{limit}/{offset}")
    public ResponseEntity<List<Customer>> getAllCustomerPath(@PathVariable int limit,
                                                         @PathVariable int offset) {
        List<Customer> customers = customerSvc.getAllCustomersParams(limit, offset);
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/{customer_id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customer_id) {
        Customer customer = customerSvc.getCustomer(customer_id);
        return ResponseEntity.ok().body(customer);
    }

    @DeleteMapping("/{customer_id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable int customer_id) {
        Boolean customerDeleted= customerSvc.deleteCustomer(customer_id);
        return ResponseEntity.ok().body(customerDeleted);
    }

    @PutMapping("/{customer_id}")
    public ResponseEntity<Boolean> updateCustomer(@PathVariable("customer_id") Integer id,
                                                  @RequestBody Customer customer) {
        Boolean customerUpdated = customerSvc.updateCustomer(id,customer);
        return ResponseEntity.ok().body(customerUpdated);
    }
}
