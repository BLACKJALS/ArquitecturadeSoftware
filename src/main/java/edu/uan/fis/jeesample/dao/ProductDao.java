package edu.uan.fis.jeesample.dao;

import edu.uan.fis.jeesample.dto.Product;
import java.util.List;

public interface ProductDao {

   
    Product create(Product product);
    Product update(Product product);
    void delete(Product product);
    Product findById(Integer productId);
    List<Product> findAll();
}
