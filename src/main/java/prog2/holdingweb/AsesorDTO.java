package prog2.holdingweb;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AsesorDTO extends UsuarioDTO{
    
    private int codigo;
    private String nombre;
    private String direccion;
    
    public AsesorDTO(int cod, String us, String pas, String nom, String dir){
        codigo = cod;
        setUs(us);
        setContraseña(pas);
        nombre = nom;
        direccion = dir;
    }
}
