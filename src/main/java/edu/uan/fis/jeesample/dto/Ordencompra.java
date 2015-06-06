
package edu.uan.fis.jeesample.dto;

import java.io.Serializable;

public class Ordencompra implements Serializable {
    private Integer Idorden;
    private String usuario;
    
public Integer getIdcompra(){
return Idorden;
}    
 
public Ordencompra(){}

public Ordencompra(int IdOrden){
this.Idorden=IdOrden;
}
public Ordencompra( String usuario, int Idcompra){
    this.Idorden=Idcompra;
    this.usuario=usuario;
}

public void setIdorden(Integer Idcompra){
this.Idorden=Idcompra;
}

public String getUsuario(){
return usuario;
}

public void setUsuario(String nombre){
this.usuario=nombre;
}




}
