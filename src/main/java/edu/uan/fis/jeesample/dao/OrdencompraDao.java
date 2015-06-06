
package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.Ordencompra;
import java.util.List;

public interface OrdencompraDao {
    Ordencompra create(Ordencompra orden);
    Ordencompra  update(Ordencompra  orden);
    void delete(Ordencompra  orden);
    Ordencompra  findById_Ordencompra(Integer IdOrden);
    List<Ordencompra> findAllId_Ordencompra();
}
