package prog2.holdingweb;

import java.util.ArrayList;


public abstract class UsuarioDTO{
    
    private String usuario;
    private String contraseña;
    
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }
    
    public String getContraseña(){
        return contraseña;
    }
    
    public void setUs(String usuario){
        this.usuario = usuario;
    }
    
    public String getUs(){
        return usuario;
    }
}
