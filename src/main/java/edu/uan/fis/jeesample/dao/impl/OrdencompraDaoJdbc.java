package edu.uan.fis.jeesample.dao.impl;


import edu.uan.fis.jeesample.dao.OrdencompraDao;
import edu.uan.fis.jeesample.dto.Ordencompra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrdencompraDaoJdbc implements OrdencompraDao {

    @Override
    public Ordencompra create(Ordencompra orden) {
       
        Connection conn = null;
        
        PreparedStatement stmt = null;
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
           
            stmt = conn.prepareStatement("INSERT INTO tbl_ordencompra (ID_ORDEN, USUARIO) VALUES ( ?, ?) ");
            stmt.setInt(1, orden.getIdcompra());
            stmt.setString(2, orden.getUsuario());
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
        return orden;
    }

    @Override
    public Ordencompra update(Ordencompra orden) {
    
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
           
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
          
            stmt = conn.prepareStatement("UPDATE tbl_ordencompra SET  USUARIO =?  WHERE ID_ORDEN= ?");  
            stmt.setString(1, orden.getUsuario());
            stmt.setInt(2, orden.getIdcompra());
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
        return orden;
    }

    @Override
    public void delete(Ordencompra orden) {
        
        Connection conn = null;
        
        PreparedStatement stmt=null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
           
            stmt= conn.prepareStatement("DELETE FROM tbl_ordencompra WHERE ID_ORDEN = ?");
            stmt.setInt(1, orden.getIdcompra());
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

    
   
    public Ordencompra findById_Ordencompra(Integer IdOrden) {
        Ordencompra ordencompra=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
            
            
            String updateTableSQL = "SELECT * FROM  tbl_ordencompra WHERE ID_ORDEN = ?";
            stmt = conn.prepareStatement(updateTableSQL);
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            
            preparedStatement.setInt(1, 3);

            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            ordencompra=new Ordencompra();
         
            int Idordencompra=rs.getInt("ID_ORDEN");   
            
            String usuario=rs.getString("USUARIO");  
            
            ordencompra.setIdorden(Idordencompra);
            System.out.println(Idordencompra);
            ordencompra.setUsuario(usuario);
             System.out.println(usuario);
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
        return ordencompra;
    }
    
    
    @Override
  
      public List<Ordencompra> findAllId_Ordencompra()  {
        Ordencompra o=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
            List<Ordencompra> p = new ArrayList<Ordencompra>();

        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
            String updateTableSQL = "SELECT * FROM  tbl_ordencompra";
            stmt = conn.prepareStatement(updateTableSQL);
            
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.executeQuery();
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            o=new Ordencompra();
            o.setIdorden(rs.getInt("ID_ORDEN"));
            o.setUsuario(rs.getString("USUARIO"));
            p.add(o);
         
            int idorden=rs.getInt("ID_ORDEN");             
            String usuario=rs.getString("USUARIO");
            
            
            o.setIdorden(idorden);  
            o.setUsuario(usuario);
            
             System.out.println(" USUARIO: "+usuario+" ID_ORDEN: "+idorden);
                 
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
        return p;
    }
    
}
  


