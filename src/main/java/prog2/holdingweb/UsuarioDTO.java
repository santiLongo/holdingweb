package prog2.holdingweb;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "usuario")
public abstract class UsuarioDTO{ // Ya funciona con hibernate
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String usuario;
    
    @Column(nullable = false)
    private String contrasenia;
    
    @Column(nullable = false)
    private String tipo;
    
    protected UsuarioDTO(){}
    
    public UsuarioDTO(String usuario, String contrasenia, String tipo){
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contraseña) {
        this.contrasenia = contraseña;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getUsuario(){
        return usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
