//
package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.Compra;
import java.util.List;

public interface CompraDao {
    Compra create(Compra compra);
    Compra  update(Compra  compra);
    void delete(Compra  compra);
    Compra  findByUsuario(String Usuario);
    List<Compra> findAllCompra();
    
}
