package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.ProductDao;
//jhon alejandro leon sissa
/**
 * 
 */

import edu.uan.fis.jeesample.dto.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDaoJdbc implements ProductDao {
    
    public Product create(Product product) {
        
        Connection conn = null;
        
        PreparedStatement stmt = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
           
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
            
            stmt = conn.prepareStatement("INSERT INTO tbl_products (ID_PRODUCT, NOMBRE, PRECIO) VALUES ( ?, ?, ? ) ");
            stmt.setInt(1, product.getProductId());
            stmt.setString(2,product.getName());
            stmt.setInt(3, product.getPrecio());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return product;
    }
    
    public Product update(Product product) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
            
            stmt = conn.prepareStatement("UPDATE tbl_products SET  NOMBRE=?, PRECIO=?  WHERE ID_PRODUCT= ?");  
            stmt.setString(1,product.getName());
            stmt.setInt(2, product.getPrecio());
            stmt.setInt(3, product.getProductId());
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return product;
    }
    
    public void delete(Product product) {
         
        Connection conn = null;
        
        PreparedStatement stmt=null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
           
            stmt= conn.prepareStatement("DELETE FROM tbl_products WHERE ID_PRODUCT = ?");
            stmt.setInt(1, product.getProductId());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
    
   
 
    
    public Product findById(Integer productId){
        Product p=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
            
            
            String updateTableSQL = "SELECT ID_PRODUCT, NOMBRE, PRECIO FROM tbl_products WHERE ID_PRODUCT = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            
            preparedStatement.setInt(1, 3);
// execute insert SQL stetement
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            p=new Product();
         
            int Idproduct=rs.getInt("ID_PRODUCT");   
            String nombre=rs.getString("NOMBRE");
            int precio=rs.getInt("PRECIO");  
            
            p.setProductId(Idproduct);
            System.out.println(Idproduct);
            p.setName(nombre);
            System.out.println(nombre);
            p.setPrecio(precio);
            System.out.println(precio);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OrdencompraDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrdencompraDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrdencompraDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrdencompraDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrdencompraDaoJdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return p;
    }
    
    

    
    
     @Override
  
      public List<Product> findAll()  {
        Product o=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
            List<Product> p = new ArrayList<Product>();

        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
            String updateTableSQL = "SELECT * FROM  tbl_products";
            stmt = conn.prepareStatement(updateTableSQL);
            
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.executeQuery();
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            o=new Product();
            
            o.setProductId(rs.getInt("ID_PRODUCT"));
            o.setName(rs.getString("NOMBRE"));
            o.setPrecio(rs.getInt("PRECIO"));
            
            p.add(o);
         
            int idproduct=rs.getInt("ID_PRODUCT");             
            String nombre=rs.getString("NOMBRE");
            int precio=rs.getInt("PRECIO");
            
            o.setProductId(idproduct);  
            o.setName(nombre);
            o.setPrecio(precio);
            
             System.out.println(" ID_PRODUCT: "+idproduct+" NOMBRE: "+nombre+"PRECIO"+precio);
                 
            }
            //stmt.executeUpdate("INSERT INTO tbl_cliente VALUES(" + cliente.getClienteId() + ",'" + cliente.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaojdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDaojdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaojdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaojdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaojdbc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return p;
    }
    
    
    

}
