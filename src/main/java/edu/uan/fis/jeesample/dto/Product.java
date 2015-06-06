package edu.uan.fis.jeesample.dto;

import java.io.Serializable;

public class Product implements Serializable {

    private String name;
    private Integer productId=0;
    private Integer precio=0;
    
    
    public Product(){}
    
    public Product(int productid){
     this.productId=productid;
     
    }
    
    public Product(int productid, String name, int precio){
    this.name=name;
    this.productId=productid;
    this.precio=precio;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public Integer getPrecio(){
    return precio;
    }
    
    public void setPrecio(Integer precio){
      this.precio=precio;
    }
   
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof Product == false)
            return false;
        Product that = (Product) o;
        return that.productId.equals(this.productId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 79 * hash + (this.productId != null ? this.productId.hashCode() : 0);
        hash = 79 * hash + (this.precio != null ? this.precio.hashCode() : 0);
        return hash;
    }
}
