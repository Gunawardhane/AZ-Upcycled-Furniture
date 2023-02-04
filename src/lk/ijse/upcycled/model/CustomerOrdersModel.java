package lk.ijse.upcycled.model;

import lk.ijse.upcycled.to.CustomerOrder;
import lk.ijse.upcycled.to.Item;
import lk.ijse.upcycled.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerOrdersModel {
    public static ArrayList<CustomerOrder> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM customerorder";
        ResultSet result = CrudUtil.execute(sql);
        ArrayList<CustomerOrder> customerOrders = new ArrayList<>();
        while (result.next()) {

            java.sql.Date date = result.getDate(2);

            customerOrders.add( new CustomerOrder(
                    result.getString(1),
                        date.toLocalDate(),
                    result.getString(3)

            ));
        }
        return customerOrders;
    }
}
