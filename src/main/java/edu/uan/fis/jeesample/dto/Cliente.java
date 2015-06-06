package edu.uan.fis.jeesample.dto;



import java.io.Serializable;

public class Cliente implements Serializable{
    private String usuario;
    private String contraseña;

public Cliente(String contraseña, String usuario){
   this.contraseña=contraseña;
   this.usuario=usuario;
}   
    public Cliente(){
    }
    
    public Cliente(String usuario){
    this.usuario=usuario;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String nombre) {
        this.usuario = nombre;
    }

    public String getConstraseña() {
        return contraseña;
    }

    public void setConstraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
