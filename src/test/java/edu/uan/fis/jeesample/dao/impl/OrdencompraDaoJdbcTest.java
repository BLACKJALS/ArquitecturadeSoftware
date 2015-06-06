package edu.uan.fis.jeesample.dao.impl;

import edu.uan.fis.jeesample.dao.impl.OrdencompraDaoJdbc;
import edu.uan.fis.jeesample.dto.Ordencompra;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

public class OrdencompraDaoJdbcTest extends TestCase {
    
    public OrdencompraDaoJdbcTest(String testName) {
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

    public void testCreate() {
        System.out.println("create");
        Ordencompra orden = new Ordencompra();
        orden.setIdorden(1010);
        orden.setUsuario("ALEJO007");
        
        OrdencompraDaoJdbc instance = new OrdencompraDaoJdbc();
        Ordencompra expResult = orden;
        Ordencompra result = instance.create(orden);
        assertEquals(expResult, result);
    }

    public void testUpdate() {
        System.out.println("update");
        Ordencompra cliente = new Ordencompra("ALEJO07",5);
        OrdencompraDaoJdbc instance = new OrdencompraDaoJdbc();
        Ordencompra expResult = cliente;
        Ordencompra result = instance.update(cliente);       
        assertEquals(expResult, result);  

    }

    public void testDelete() {
        System.out.println("delete");
        Ordencompra orden = new Ordencompra(3);
        orden.getIdcompra();
        OrdencompraDaoJdbc instance = new OrdencompraDaoJdbc();
        instance.delete(orden);    
    }

    public void testFindById() {
        System.out.println("findById");
        Integer IdOrden = null;
        OrdencompraDaoJdbc instance = new OrdencompraDaoJdbc();
        Ordencompra expResult = null;
        Ordencompra result = instance.findById_Ordencompra(IdOrden);
        
    }

    public void testFindAll() {
        System.out.println("findAll");
        OrdencompraDaoJdbc instance = new OrdencompraDaoJdbc();
        List expResult = null;
        List result = instance.findAllId_Ordencompra();
       
    }
}

