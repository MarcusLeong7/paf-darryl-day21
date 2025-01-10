package vttp.paf.day21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vttp.paf.day21.model.Employee;
import vttp.paf.day21.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepo;

    // Get/Read
    public List<Employee> getAllEmployees() {
        return employeeRepo.getEmployees();
    }

    // Get/Read
    public Employee getEmployeeById(int id) {
        return employeeRepo.getEmployee(id);
    }

    // Put/Create
    public Employee addEmployee(Employee employee) {
        return employeeRepo.insertNewEmployee(employee);
    }
}
