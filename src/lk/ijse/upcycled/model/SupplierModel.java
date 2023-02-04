package lk.ijse.upcycled.model;

import lk.ijse.upcycled.to.Item;
import lk.ijse.upcycled.to.Supplier;
import lk.ijse.upcycled.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierModel {
    public static boolean save(Supplier supplier) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO supplier VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql, supplier.getSupplierID(), supplier.getSupplierName(), supplier.getSupplierAddress(), supplier.getSupplierPhoneNumber());
    }

    public static boolean update(Supplier supplier) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE supplier set name=? , address=?, phonenumber=? where supplierid=?";
        return  (CrudUtil.execute(sql,supplier.getSupplierName(),supplier.getSupplierAddress(),supplier.getSupplierPhoneNumber(),supplier.getSupplierID()));

    }

    public static Supplier search(String supplierID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM supplier WHERE supplierid = ?";
        ResultSet result = CrudUtil.execute(sql, supplierID);
        if(result.next()) {
            return new Supplier(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)


            );
        }
        return null;
    }

    public static boolean delete(String supplierID) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM supplier WHERE supplierid = ?";
        return CrudUtil.execute(sql,supplierID);
    }

    public static ArrayList<Supplier> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM supplier";
        ResultSet result = CrudUtil.execute(sql);
        ArrayList<Supplier> supplier = new ArrayList<>();
        while (result.next()) {
            supplier.add( new Supplier(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            ));
        }
        return supplier;
    }


}
