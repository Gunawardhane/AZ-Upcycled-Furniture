package lk.ijse.upcycled.model;

import lk.ijse.upcycled.to.CartDetails;
import lk.ijse.upcycled.to.CustomerOrder;
import lk.ijse.upcycled.to.OrderDetail;
import lk.ijse.upcycled.util.CrudUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailModel {

    public static boolean saveOrderDetails(ArrayList<CartDetails> cartDetails) throws SQLException, ClassNotFoundException {
        for (CartDetails orderDetail : cartDetails) {
            String sql = "INSERT INTO sellerdetails VALUES (?, ?, ?, ?)";
            return CrudUtil.execute(sql, orderDetail.getOrderID(), orderDetail.getCode(), orderDetail.getQty(), orderDetail.getUnitPrice());
        }
        return true;
    }

    public static boolean save(CartDetails orderDetail) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO sellerdetails VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql, orderDetail.getOrderID(), orderDetail.getCode(), orderDetail.getQty(), orderDetail.getUnitPrice());
    }
}
