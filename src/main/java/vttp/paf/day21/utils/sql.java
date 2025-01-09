package vttp.paf.day21.utils;

public class sql {

    public static final String SQL_GET_ALL_ROOMS = "select * from room";
    public static final String SQL_GET_ALL_CUSTOMERS = "select * from customer limit ? offset ?";
    public static final String SQL_GET_ALL_CUSTOMERS_LIMIT_OFFSET = "select * from customer limit ? offset ?";

}
