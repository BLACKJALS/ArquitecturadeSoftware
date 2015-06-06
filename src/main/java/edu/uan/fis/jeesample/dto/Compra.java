
package edu.uan.fis.jeesample.dto;

import java.io.Serializable;


public class Compra implements Serializable {
    private Integer Idproducto;
    private String usuario;
    private Integer Idcompra;    
 
public Compra(){}



public Compra(int Idcompra){
this.Idcompra=Idcompra;
}

 
public Compra( int Idproducto, String usuario){
this.Idproducto=Idproducto;
this.usuario=usuario;
}

public Compra( int Idproducto, String usuario, int Idcompra){
this.Idproducto=Idproducto;
this.usuario=usuario;
this.Idcompra=Idcompra;
}

public Integer getIdproducto(){
return Idproducto;
}    



public void setIdproducto(Integer Idcompra){
this.Idproducto=Idcompra;
} 

public String getUsuario(){
return usuario;
}

public void setUsuario(String usuario){
    this.usuario=usuario;
}


public Integer getIdcompra(){
return Idcompra;
}    



public void setIdcompra(Integer Idcompra){
this.Idcompra=Idcompra;
} 

}
