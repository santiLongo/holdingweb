package prog2.holdingweb;

import java.util.ArrayList;


public abstract class UsuarioDTO{
    
    private String usuario;
    private String contraseña;
    
    public void setContrasenia(String contraseña){
        this.contraseña = contraseña;
    }
    
    public String getContrasenia(){
        return contraseña;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getUsuario(){
        return usuario;
    }
}
