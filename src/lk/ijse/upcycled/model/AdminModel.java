package lk.ijse.upcycled.model;

import lk.ijse.upcycled.to.Admin;
import lk.ijse.upcycled.to.Item;
import lk.ijse.upcycled.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminModel {
    public static Admin search(String username, String password) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM admin WHERE username = ? && password = ?";
        ResultSet result = CrudUtil.execute(sql, username, password);
        if(result.next()) {
            return new Admin(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3)
            );
        }
        return null;
    }
}
