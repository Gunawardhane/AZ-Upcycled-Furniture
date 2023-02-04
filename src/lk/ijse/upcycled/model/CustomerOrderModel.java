package lk.ijse.upcycled.model;

import lk.ijse.upcycled.to.Supplier;
import lk.ijse.upcycled.util.CrudUtil;
import lk.ijse.upcycled.to.CustomerOrder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javafx.scene.control.Label;
import java.util.Date;
import java.util.TimeZone;

import static javax.print.attribute.Size2DSyntax.MM;

public class CustomerOrderModel {
    public static boolean save(CustomerOrder customerOrder) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO customerorder VALUES (?, ?, ?)";
        return CrudUtil.execute(sql, customerOrder.getCustomerOrderID(), customerOrder.getDate(), customerOrder.getCustomerID());
    }

    public static boolean update(CustomerOrder customerOrder) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE customerorder set amount=? , cusid=? where orderid=?";
        return  (CrudUtil.execute(sql,customerOrder.getDate(),customerOrder.getCustomerID(),customerOrder.getCustomerOrderID()));

    }

//    public static CustomerOrder search(String customerOrderid) throws SQLException, ClassNotFoundException {
//        String sql = "SELECT  * FROM customerorder WHERE orderid = ?";
//        ResultSet result = CrudUtil.execute(sql, customerOrderid);
//        if(result.next()) {
//            return new CustomerOrder(
//                    result.getString(1),
//                    LocalDate.of(result.getDate(2).getYear(),result.getDate(2).getMonth(),result.getDate(2).getDay()), //meka coomment kara mt date eka ganna eke aulak awa bn.
//                    result.getString(3)
//
//            );
//        }
//        return null;
//    }

    public static boolean delete(String customerOrderID) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM customerorder WHERE orderid = ?";
        return CrudUtil.execute(sql,customerOrderID);
    }

//    public static ArrayList<CustomerOrder> getAll() throws SQLException, ClassNotFoundException {
//        String sql = "SELECT  * FROM customerorder";
//        ResultSet result = CrudUtil.execute(sql);
//        ArrayList<CustomerOrder> customerOrder = new ArrayList<>();
//
//        Date date = Calendar.getInstance().getTime();
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//        String strDate = dateFormat.format(date);
//
//        while (result.next()) {
//            customerOrder.add( new CustomerOrder(
//                    result.getString(1),
//                   result.getDate(2,strDate),
//            result.getString(3)
//            ));
//        }
//        return customerOrder;
//    }

    public static String generateOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.execute("SELECT orderid FROM customerorder ORDER BY orderid DESC LIMIT 1");
        return rst.next() ? String.format("OID%03d", (Integer.parseInt(rst.getString("orderid").replace("OID", "")) + 1)) : "OID001";
    }


}