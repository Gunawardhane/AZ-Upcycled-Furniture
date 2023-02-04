package lk.ijse.upcycled.model;

import lk.ijse.upcycled.to.CustomerOrder;
import lk.ijse.upcycled.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderModel {
    public static boolean save(CustomerOrder customerOrder) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO customerorder VALUES(?, ?, ?)";
        return CrudUtil.execute(sql, customerOrder.getCustomerOrderID(), customerOrder.getDate(), customerOrder.getCustomerID());
    }

    public static String generateNextOrderId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT orderid FROM customerorder ORDER BY orderid DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return generateNextOrderId(result.getString(1));
        }
        return generateNextOrderId(result.getString(null));
    }

    private static String generateNextOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("C0");
            int id = Integer.parseInt(split[1]);
            id += 1;
            return "D0" + id;
        }
        return "O001";

    }
}
