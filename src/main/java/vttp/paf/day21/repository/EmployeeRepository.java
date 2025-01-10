package vttp.paf.day21.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import vttp.paf.day21.model.Customer;
import vttp.paf.day21.model.Employee;
import vttp.paf.day21.model.Exception.ResourceNotFoundException;
import vttp.paf.day21.utils.sql;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate template;

    // Read
    public List<Employee> getEmployees() {
        final List<Employee> employees = new ArrayList<Employee>();
        SqlRowSet rs = template.queryForRowSet(sql.SQL_GET_ALL_EMPLOYEES);
        while (rs.next()) {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setFirst_name(rs.getString("first_name"));
            employee.setLast_name(rs.getString("last_name"));
            employee.setEmail(rs.getString("email"));
            employee.setJob_title(rs.getString("job_title"));
            employee.setDepartment(rs.getString("department"));
            employee.setEmployment_date(rs.getDate("employment_date"));
            employee.setSalary(rs.getFloat("salary"));
            employee.setActive(rs.getBoolean("active"));

            employees.add(employee);
        }

        if (employees.isEmpty()) {
            throw new ResourceNotFoundException("No employees found");
        }

        return employees;
    }

    // Read
    public Employee getEmployee(int id) {
        SqlRowSet rs = template.queryForRowSet(sql.SQL_GET_EMPLOYEE_BY_ID);
        if (rs.next()) {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setFirst_name(rs.getString("first_name"));
            employee.setLast_name(rs.getString("last_name"));
            employee.setEmail(rs.getString("email"));
            employee.setJob_title(rs.getString("job_title"));
            employee.setDepartment(rs.getString("department"));
            employee.setEmployment_date(rs.getDate("employment_date"));
            employee.setSalary(rs.getFloat("salary"));
            employee.setActive(rs.getBoolean("active"));
            return employee;
        } else {
            throw new ResourceNotFoundException("No employees found");
        }
    }

    // Delete
    public Boolean deleteEmployee(int id) {
        int employeeDeleted = template.update(sql.SQL_DELETE_EMPLOYEE);
        if (employeeDeleted > 0) {
            return true;
        }
        return false;
    }

    // Update
    public Boolean updateEmployee(final int id,Employee employee) {
        int employeeUpdated = template.update(sql.SQL_INSERT_EMPLOYEE,
                employee.getFirst_name(),employee.getLast_name(),employee.getEmail(),
                employee.getJob_title(),employee.getDepartment(),employee.getSalary(),employee.getActive(),id);

        if (employeeUpdated > 0) {
            return true;
        }
        return false;
    }

    // Create
    public Boolean insertNewEmployee(Employee employee) {
        int employeeCreated = template.update(sql.SQL_INSERT_EMPLOYEE,
                employee.getFirst_name(),employee.getLast_name(),employee.getEmail(),
                employee.getJob_title(),employee.getDepartment(),employee.getEmployment_date(),employee.getSalary(),employee.getActive());
        if (employeeCreated > 0) {
            return true;
        }
        return false;
    }
}
