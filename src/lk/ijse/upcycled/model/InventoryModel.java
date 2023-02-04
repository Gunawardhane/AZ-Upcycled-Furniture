package lk.ijse.upcycled.model;

import lk.ijse.upcycled.to.Inventory;
import lk.ijse.upcycled.to.Item;
import lk.ijse.upcycled.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InventoryModel {
    public static boolean save(Inventory inventory) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO inventory VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql, inventory.getIvID(), inventory.getQOH(), inventory.getSupID(), inventory.getItemID());
    }

    public static boolean update(Inventory inventory) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE inventory set qtyonhand=? , supplierid=?, itemid=? where inventoryid=?";
        return  (CrudUtil.execute(sql,inventory.getQOH(),inventory.getSupID(),inventory.getItemID(),inventory.getIvID()));

    }

    public static Inventory search(String invenotryid) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM inventory WHERE inventoryid = ?";
        ResultSet result = CrudUtil.execute(sql, invenotryid);
        if(result.next()) {
            return new Inventory(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)


            );
        }
        return null;
    }

    public static boolean delete(String inventoryid) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM inventory WHERE inventoryid = ?";
        return CrudUtil.execute(sql,inventoryid);
    }

    public static ArrayList<Inventory> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM inventory";
        ResultSet result = CrudUtil.execute(sql);
        ArrayList<Inventory> inventories = new ArrayList<>();
        while (result.next()) {
            inventories.add( new Inventory(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            ));
        }
        return inventories;
    }
}
