//JHON ALEJANDRO LEON SISSA
package edu.uan.fis.jeesample.dao;


import edu.uan.fis.jeesample.dto.Cliente;
import java.util.List;


public interface ClienteDao {
    Cliente create(Cliente cliente);
    Cliente update(Cliente cliente);
    void delete(Cliente cliente);
    Cliente findByUsuario(String usuario);
    List<Cliente> findAllUsuario();
  
}
