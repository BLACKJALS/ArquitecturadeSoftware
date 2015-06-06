package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.impl.ClienteDaojdbc;
import edu.uan.fis.jeesample.dto.Cliente;
import java.util.List;
import junit.framework.TestCase;

public class ClienteDaoJdbcTest extends TestCase {
    
    public ClienteDaoJdbcTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testCreate() throws Exception{
        System.out.println("create");
        Cliente cliente = new Cliente();
        cliente.setUsuario("ALEJO007");
        cliente.setConstraseña("JALS");
        
        ClienteDaojdbc instance = new ClienteDaojdbc();
        Cliente expResult = cliente;
        Cliente result = instance.create(cliente);
        assertEquals(expResult, result);    
    }

    public void testUpdate() {
        System.out.println("update");
        Cliente cliente = new Cliente("CRAS34","CRASH");
        ClienteDaojdbc instance = new ClienteDaojdbc();
        Cliente expResult = cliente;
        Cliente result = instance.update(cliente);       
        assertEquals(expResult, result);  
     
    }

    public void testDelete() {
        System.out.println("delete");
        Cliente cliente = new Cliente("RASI");
        cliente.getUsuario();
        ClienteDaojdbc instance = new ClienteDaojdbc();
        instance.delete(cliente);    
    }

    public void testFindById() {
        System.out.println("findById");
        String usuario = null;
        ClienteDaojdbc instance = new ClienteDaojdbc();
        Cliente expResult = null;
        Cliente result = instance.findByUsuario(usuario);  
        
        
    }

    public void testFindAll() {
        System.out.println("findAll");
        ClienteDaojdbc instance = new ClienteDaojdbc();
        List expResult = null;
        List result = instance.findAllUsuario();
       
    }
}

