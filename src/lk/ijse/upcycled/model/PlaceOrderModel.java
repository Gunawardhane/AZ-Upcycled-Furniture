package lk.ijse.upcycled.model;

import lk.ijse.upcycled.db.DBConnection;
import lk.ijse.upcycled.to.CustomerOrder;
import lk.ijse.upcycled.to.PlaceOrder;
import lk.ijse.upcycled.to.CustomerOrder;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class PlaceOrderModel {
    public static boolean placeOrder(PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
            Connection connection = DBConnection.getDBConnection().getConnection();
            connection.setAutoCommit(false);
            boolean isOrderAdded = OrderModel.save(new CustomerOrder(placeOrder.getOrderID(), LocalDate.now(), placeOrder.getCustomerID()));
            if (!isOrderAdded) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

        boolean isUpdated = ItemModel.updateQty(placeOrder.getOrderDetails());

            if (!isUpdated) {
                connection.commit();
                connection.setAutoCommit(true);
                return true;
            }

            connection.commit();
            connection.setAutoCommit(true);



            return true;

        }
}
