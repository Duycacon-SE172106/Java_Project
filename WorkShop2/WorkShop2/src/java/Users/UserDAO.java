/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import DBUtils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author chinl
 */
public class UserDAO {

    private static final String LOGIN = "SELECT fullName,role FROM Users WHERE userID=? AND password=?";

    public UserDTO checkLogin(String userID, String password) throws ClassNotFoundException, SQLException, NamingException {
        Connection conn = null;
        UserDTO user = new UserDTO();
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(LOGIN);
                psm.setString(1, userID);
                psm.setString(2, password);
                rs = psm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    int role = rs.getInt("role");
                    user = new UserDTO(userID, "***", fullName, role);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

}
