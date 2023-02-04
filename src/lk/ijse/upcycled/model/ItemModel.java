package lk.ijse.upcycled.model;

import lk.ijse.upcycled.to.Item;
import lk.ijse.upcycled.util.CrudUtil;
import lk.ijse.upcycled.to.CartDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemModel {
    public static boolean save(Item item) throws SQLException, ClassNotFoundException {

        String sql = "INSERT INTO item VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql, item.getItemID(), item.getName(), item.getUnitPrice(), item.getQOH());
    }

    public static boolean update(Item item) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE item set name=? , sellingprice=?, buyingprice=? where itemid=?";
        return  (CrudUtil.execute(sql,item.getName(),item.getUnitPrice(),item.getQOH(),item.getItemID()));

    }

    public static Item search(String itemid) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM item WHERE itemid = ?";
        ResultSet result = CrudUtil.execute(sql, itemid);
        if(result.next()) {
            return new Item(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)


            );
        }
        return null;
    }
    public static boolean delete(String itemid) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM item WHERE itemid = ?";
        return CrudUtil.execute(sql,itemid);
    }

    public static ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM item";
        ResultSet result = CrudUtil.execute(sql);
        ArrayList<Item> items = new ArrayList<>();
        while (result.next()) {
            items.add( new Item(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            ));
        }
        return items;
    }
    public static boolean updateQty(ArrayList<CartDetails> cartDetails) throws SQLException, ClassNotFoundException {
        for (CartDetails cartDetail : cartDetails) {
            if (!updateItemQty(new Item(cartDetail.getCode(), cartDetail.getName(), cartDetail.getUnitPrice(), cartDetail.getQty()))) {
                return false;
            }
        }
        return true;
    }
    private static boolean updateItemQty(Item item) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE item SET qoh = qoh - ? WHERE itemid = ?";
        System.out.println(item.getItemID());
        return CrudUtil.execute(sql, item.getQOH(), item.getItemID());
    }

    public static ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
        String sql = "SELECT itemid FROM item";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> codeList = new ArrayList<>();

        while (result.next()) {
            codeList.add(result.getString(1));
        }
        return codeList;
    }

}
