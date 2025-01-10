package vttp.paf.day21.utils;

public class sql {

    // CUSTOMER
    public static final String SQL_GET_ALL_CUSTOMERS = "select * from customer";
    public static final String SQL_GET_ALL_CUSTOMERS_LIMIT_OFFSET = "select * from customer limit ? offset ?";
    // Get customer by id
    public static final String SQL_GET_CUSTOMER_BY_ID = "select * from customer where id = ?";
    // Insert customer
    public static final String SQL_INSERT_CUSTOMER = "insert into customer (full_name,email) values (?,?)";
    // Delete customer
    public static final String SQL_DELETE_CUSTOMER_BY_ID = "delete from customer where id = ?";
    // Update customer
    public static final String SQL_UPDATE_CUSTOMER_BY_ID = "update customer set full_name = ?, email = ? where id = ?";

    // ROOM
    public static final String SQL_GET_ALL_ROOMS = "select * from room";
    public static final String SQL_GET_ROOM_BY_ID = "select * from room where id = ?";
    public static final String SQL_DELETE_ROOM_BY_ID = "delete from room where id = ?";
    public static final String SQL_UPDATE_ROOM_BY_ID = "update room set room_type = ?, price = ? where id = ?";
    public static final String SQL_INSERT_ROOM = "insert into room (room_type,price) values (?,?)";


    // EMPLOYEE
    public static final String SQL_GET_ALL_EMPLOYEES = "select * from employee";
    public static final String SQL_INSERT_EMPLOYEE=
            "insert into employee (first_name,last_name,email,job_title,department,employment_date,salary,active) " +
                    "values (?,?,?,?,?,?,?,?)";
    public static final String SQL_DELETE_EMPLOYEE= "update employee set active = false where id = ?";
    public static final String SQL_UPDATE_EMPLOYEE = "update employee set " +
            "first_name = ?," +
            "last_name = ?," +
            "email = ?," +
            "job_title = ?," +
            "department = ?," +
            "employment_date" +
            "salary" +
            "where id = ?";
    public static final String SQL_GET_EMPLOYEE_BY_ID = "select * from employee where id = ?";
}
