/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmedreda
 */
public class ProductManager implements DAO_Interface
{

    final String URL = "jdbc:mysql://localhost:3306";
    final String ID = "root";
    final String PASS = "123456";
    private Connection conn;
    private PreparedStatement pst;
    private Product product;

    public ProductManager()
    {
        Connection conn;
        Statement st;
        try {
            DriverManager.registerDriver(new Driver());
            this.conn = DriverManager.getConnection(this.URL, this.ID, this.PASS);
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Product> getAllProducts()
    {
        List<Product> pros = new ArrayList<>();

        try {
            this.pst = this.conn.prepareStatement("select * from Products.Products");
            ResultSet rs = this.pst.executeQuery();

            while (rs.next()) {
                pros.add(new Product(rs.getString("name"),rs.getDouble("price")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pros;
    }

    @Override
    public Product getProductById(int id)
    {
        Product pro = null;
        try {
            this.pst = this.conn.prepareStatement("select * from Products.Products where id = ?");
            this.pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
//                Error
//                this.product.setName(rs.getString("name"));
//                this.product.setPrice(rs.getDouble("price"));
                pro = new Product(rs.getString("name"), rs.getDouble("price"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pro;

    }

    @Override
    public Product getProductByName(String name)
    {
        Product pro = null;
        try {
            this.pst = this.conn.prepareStatement("Select * from Products.Products where name = ?");
            this.pst.setString(1, name);

            ResultSet rs = this.pst.executeQuery();

            while (rs.next()) {
//                this.product.setName(rs.getString("name"));
//                this.product.setPrice(rs.getDouble("price"));
                pro = new Product(rs.getString("name"), rs.getDouble("price"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pro;
    }

    @Override
    public void deleteProductById(int id)
    {
        try {
            this.pst = this.conn.prepareStatement("delete from Products.Products where id = ?");
            this.pst.setInt(1, id);
            this.pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deleteProductByName(String name)
    {
        try {
            this.pst = this.conn.prepareStatement("delete from Products.Products where name = ?");
            this.pst.setString(1, name);
            this.pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void InsertProduct(String name, double price)
    {
        try {
            this.pst = this.conn.prepareStatement("Insert into Products.Products (name , price) values (?,?)");
            this.pst.setString(1, name);
            this.pst.setDouble(2, price);
            this.pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateProductById(int id, String name, double price)
    {
        try {
            this.pst = this.conn.prepareStatement("update Products.Products set name = ? ,price =? where id =?");
            this.pst.setString(1, name);
            this.pst.setDouble(2, price);
            this.pst.setInt(3, id);
            this.pst.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void bulkInsert(Map<String, Double> map)
    {
        map.entrySet().stream().forEach((entry) -> {
            this.InsertProduct(entry.getKey(), entry.getValue());
        });
    }

}
