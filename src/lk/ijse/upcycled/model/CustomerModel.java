package lk.ijse.upcycled.model;

import lk.ijse.upcycled.to.Customer;
import lk.ijse.upcycled.to.Item;
import lk.ijse.upcycled.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {
    public static boolean save(Customer customer) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO customer VALUES (?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, customer.getCusId(), customer.getName(), customer.getEmail(),customer.getPn(),customer.getAddress());
    }

    public static boolean update(Customer customer) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE customer set name=? , email=?, phonenumber=?, address=? where cusid=?";
        return  (CrudUtil.execute(sql,customer.getName(),customer.getEmail(),customer.getPn(),customer.getAddress(),customer.getCusId()));

    }

    public static Customer search(String cusId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM customer WHERE cusid = ?";
        ResultSet result = CrudUtil.execute(sql, cusId);
        if(result.next()) {
            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)


            );
        }
        return null;
    }
    public static boolean delete(String cusId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM customer WHERE cusid = ?";
        return CrudUtil.execute(sql,cusId);
    }

    public static ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM customer";
        ResultSet result = CrudUtil.execute(sql);
        ArrayList<Customer> customers = new ArrayList<>();
        while (result.next()) {
            customers.add( new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)
            ));
        }
        return customers;
    }

    public static ArrayList<String> loadCustomerIds() throws SQLException, ClassNotFoundException {
        String sql = "SELECT cusid FROM customer";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> idList = new ArrayList<>();

        while (result.next()) {
            idList.add(result.getString(1));
        }
        return idList;
    }


}
