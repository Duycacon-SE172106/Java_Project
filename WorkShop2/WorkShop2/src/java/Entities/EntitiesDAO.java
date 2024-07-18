/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import DBUtils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author chinl
 */
public class EntitiesDAO {

    private static final String SEARCH = "SELECT mobileId, description, price, mobileName, yearOfProduction, quantity, notSale FROM Mobiles WHERE mobileId LIKE ? OR mobileName LIKE ?";
    private static final String UPDATE = "UPDATE Mobiles SET description=?, price=?, mobileName=?, yearOfProduction=?, quantity=? WHERE mobileId=?";
    private static final String INSERT = "INSERT INTO Mobiles (mobileId, description, price, mobileName, yearOfProduction, quantity, notSale) VALUES(?,?,?,?,?,?,?)";
    private static final String DELETE = "DELETE Mobiles WHERE mobileId=?";
    private static final String SEARCH02 = "SELECT mobileId, description, price, mobileName, yearOfProduction, quantity, notSale FROM Mobiles WHERE notSale ='false' AND (price BETWEEN  ? AND ?)";
    private static final String GET_LIST_PRODUCT = "SELECT mobileId, description, price, mobileName, yearOfProduction, quantity, notSale FROM Mobiles WHERE quantity >0";
    
    public List<EntitiesDTO> getListProducts() throws SQLException, ClassNotFoundException, NamingException {
        List<EntitiesDTO> listProducts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(GET_LIST_PRODUCT);
                rs = psm.executeQuery();
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    listProducts.add(new EntitiesDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale));
                }
            }
        } catch (SQLException e) {
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
        return listProducts;
    }
    
    public List<EntitiesDTO> getListProducts(String search) throws SQLException, ClassNotFoundException, NamingException {
        List<EntitiesDTO> listProducts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(SEARCH);

                psm.setString(1, "%" + search + "%");
                psm.setString(2, "%" + search + "%");
                rs = psm.executeQuery();
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    listProducts.add(new EntitiesDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale));
                }
            }
        } catch (SQLException e) {
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
        return listProducts;
    }

    public boolean update(EntitiesDTO product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement psm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(UPDATE);
                psm.setString(1, product.getDescription());
                psm.setFloat(2, product.getPrice());
                psm.setString(3, product.getMobileName());
                psm.setInt(4, product.getYearOfProduct());
                psm.setInt(5, product.getQuantity());
                psm.setString(6, product.getMobileId());
                check=psm.executeUpdate()>0?true:false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean insert(EntitiesDTO product) throws SQLException{
        Connection conn=null;
        PreparedStatement psm=null;
        try{
            conn=DBUtils.getConnection();
            if(conn!=null){
                psm=conn.prepareStatement(INSERT);
                psm.setString(1, product.getMobileId());
                psm.setString(2, product.getDescription());
                psm.setFloat(3, product.getPrice());
                psm.setString(4, product.getMobileName());
                psm.setInt(5, product.getYearOfProduct());
                psm.setInt(6, product.getQuantity());
                psm.setBoolean(7, product.isNotSale());
                return psm.executeUpdate()>0?true:false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(psm!=null)psm.close();
            if(conn!=null)conn.close();
        }return false;
    }
    
    public boolean delete(String mobileId) throws SQLException{
        Connection conn=null;
        PreparedStatement psm=null;
        try{
            conn=DBUtils.getConnection();
            if(conn!=null){
                psm=conn.prepareStatement(DELETE);
                psm.setString(1, mobileId);
                return psm.executeUpdate()>0?true:false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(psm!=null)psm.close();
            if(conn!=null)conn.close();
        }return false;
    }
    
    public List<EntitiesDTO> getListProducts02(int value01,int value02) throws SQLException, ClassNotFoundException, NamingException {
        List<EntitiesDTO> listProducts = new ArrayList<>();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                psm = conn.prepareStatement(SEARCH02);
                psm.setInt(1, value01);
                psm.setInt(2, value02 );
                rs = psm.executeQuery();
                while (rs.next()) {
                    String mobileId = rs.getString("mobileId");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    String mobileName = rs.getString("mobileName");
                    int yearOfProduction = rs.getInt("yearOfProduction");
                    int quantity = rs.getInt("quantity");
                    boolean notSale = rs.getBoolean("notSale");
                    listProducts.add(new EntitiesDTO(mobileId, description, price, mobileName, yearOfProduction, quantity, notSale));
                }
            }
        } catch (SQLException e) {
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
        return listProducts;
    }
}
