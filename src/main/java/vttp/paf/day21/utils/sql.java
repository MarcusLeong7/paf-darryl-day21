package vttp.paf.day21.utils;

public class sql {

    // CUSTOMER
    public static final String SQL_GET_ALL_CUSTOMERS = "select * from customer";
    public static final String SQL_GET_ALL_CUSTOMERS_LIMIT_OFFSET = "select * from customer limit ? offset ?";
    // Get customer by id
    public static final String SQL_GET_CUSTOMER_BY_ID = "select * from customer where id = ?";
    // Delete customer
    public static final String SQL_DELETE_CUSTOMER_BY_ID = "delete from customer where id = ?";
    // Update customer
    public static final String SQL_UPDATE_CUSTOMER_BY_ID = "update customer set full_name = ?, email = ? where id = ?";

    // ROOM
    public static final String SQL_GET_ALL_ROOMS = "select * from room";
    public static final String SQL_GET_ROOM_BY_ID = "select * from room where id = ?";
    public static final String SQL_DELETE_ROOM_BY_ID = "delete from room where id = ?";
    public static final String SQL_UPDATE_ROOM_BY_ID = "update room set room_type = ?, price = ? where id = ?";
}
