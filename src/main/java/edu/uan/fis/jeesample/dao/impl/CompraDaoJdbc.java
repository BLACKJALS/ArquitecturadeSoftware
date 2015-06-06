
package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.CompraDao;
import edu.uan.fis.jeesample.dto.Compra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompraDaoJdbc implements CompraDao{

    @Override
    public Compra create(Compra compra) {
      
        Connection conn = null;
   
        PreparedStatement stmt = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");     
            stmt = conn.prepareStatement("INSERT INTO tbl_compra (ID_PRODUCT, USUARIO, ID_COMPRA) VALUES ( ?, ?,?) ");
            stmt.setInt(1, compra.getIdproducto());
            stmt.setString(2, compra.getUsuario());
            stmt.setInt(3, compra.getIdcompra());
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
        return compra;
    }

    @Override
    public Compra update(Compra compra) {
       
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
           
            stmt = conn.prepareStatement("UPDATE tbl_compra SET  ID_PRODUCT =?, USUARIO=?  WHERE ID_COMPRA= ?");  
            stmt.setInt(1, compra.getIdproducto());
            stmt.setString(2, compra.getUsuario());
            stmt.setInt(3, compra.getIdcompra());
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
        return compra;
    }

    @Override
    public void delete(Compra compra) {
        
        Connection conn = null;
        
        PreparedStatement stmt=null;
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
           
            stmt= conn.prepareStatement("DELETE FROM tbl_compra WHERE ID_COMPRA = ?");
            stmt.setInt(1, compra.getIdcompra());
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

    @Override
    public Compra findByUsuario(String Usuario) {
       Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Compra o= null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
            
            stmt = conn.prepareStatement("SELECT * FROM  tbl_compra WHERE USUARIO = ?");
            stmt.setString(1, Usuario);
            rs = stmt.executeQuery();
            while(rs.next()){
            o = new Compra();
             o.setUsuario(rs.getString("USUARIO"));
            o.setIdproducto(rs.getInt("ID_PRODUCT"));
            o.setIdcompra(rs.getInt("ID_COMPRA"));
                

            }
            
            
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
        return o;
    }

  
    
    public List<Compra> findAllCompra() {
        Compra o=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
            List<Compra> compra = new ArrayList<Compra>();

        try {
           
            Class.forName("com.mysql.jdbc.Driver");
           
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
            String updateTableSQL = "SELECT * FROM tbl_cliente";
            stmt = conn.prepareStatement(updateTableSQL);
           
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.executeQuery();
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            o=new Compra();
            o.setUsuario(rs.getString("USUARIO"));
            o.setIdproducto(rs.getInt("ID_PRODUCT"));
            o.setIdcompra(rs.getInt("ID_COMPRA"));
            compra.add(o);
            
            String usuario=rs.getString("USUARIO"); 
            int idproduct=rs.getInt("ID_PRODUCT");             
            int idcompra=rs.getInt("ID_COMPRA");
            
            o.setUsuario(usuario);
            o.setIdproducto(idproduct);
            o.setIdcompra(idcompra);  
            
            
            
             System.out.println(" USUARIO: "+usuario+" ID_PRODUCT: "+idproduct+" ID_COMPRA: "+idcompra);
                 
            }
            
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
        return compra;
    }
    
}
