package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.ClienteDao;
import edu.uan.fis.jeesample.dto.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDaojdbc implements ClienteDao {

    @Override
    public Cliente create(Cliente cliente) {
         
        Connection conn = null;
        
        PreparedStatement stmt = null;
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
           
            stmt = conn.prepareStatement("INSERT INTO tbl_cliente (USUARIO, CONTRASEÑA) VALUES ( ?, ? ) ");
            stmt.setString(1,cliente.getUsuario());
            stmt.setString(2, cliente.getConstraseña());
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
        return cliente;
    }

    @Override
    public Cliente update(Cliente cliente) {
      
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
            
            stmt = conn.prepareStatement("UPDATE tbl_cliente SET  CONTRASEÑA=?  WHERE USUARIO= ?");  
            stmt.setString(1,cliente.getConstraseña());
            stmt.setString(2,cliente.getUsuario());
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
        return cliente;
    }

    @Override
    public void delete(Cliente cliente) {
       
        Connection conn = null;
       
        PreparedStatement stmt=null;
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
           
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
            
            stmt= conn.prepareStatement("DELETE FROM tbl_cliente WHERE USUARIO = ?");
            stmt.setString(1, cliente.getUsuario());
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
    public Cliente findByUsuario(String usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Cliente c= null;
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
           
            stmt = conn.prepareStatement("SELECT * FROM  tbl_cliente WHERE USUARIO = ?");
            stmt.setString(1, usuario); 
            rs = stmt.executeQuery();
            while(rs.next()){
            c = new Cliente();
            c.setConstraseña(rs.getString("CONTRASEÑA"));
            c.setUsuario(rs.getString("USUARIO"));
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
        return c;
    }

    
    
     public List<Cliente> findAllUsuario() {
        Cliente c=null;
        Connection conn = null;
        ResultSet rs=null;
        PreparedStatement stmt = null;
            List<Cliente> clientes = new ArrayList<Cliente>();

        try {
            // 1. Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // 2. Get the connection for the URL jdbc:mysql://address:port/dbname?user=username&password=userpassword
            conn = DriverManager.getConnection("jdbc:mysql://localhost/electiva1" , "root", "123456");
            String updateTableSQL = "SELECT * FROM tbl_cliente";
            stmt = conn.prepareStatement(updateTableSQL);
            // 3. actualizar cliente en la base de datos
            
            PreparedStatement preparedStatement = conn.prepareStatement(updateTableSQL);
            preparedStatement.executeQuery();
            rs=preparedStatement.executeQuery();
            while (rs.next())
            {
            c=new Cliente();
            c.setUsuario(rs.getString("USUARIO"));
            c.setConstraseña(rs.getString("CONTRASEÑA"));;
            clientes.add(c);
         
            String usuario=rs.getString("USUARIO");             
            String contraseña=rs.getString("CONTRASEÑA");
            c.setConstraseña(contraseña);  
            c.setUsuario(usuario);
            
             System.out.println(" USUARIO: "+usuario+" Contraseña: "+contraseña);
                 
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
        return clientes;
    }
  
}

