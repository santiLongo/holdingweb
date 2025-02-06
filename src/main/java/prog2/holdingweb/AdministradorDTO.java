package prog2.holdingweb;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "administrador")
@PrimaryKeyJoinColumn(name = "id")
public class AdministradorDTO extends UsuarioDTO{ // Ya funciona con hibernate
    
    protected AdministradorDTO(){}
    
    public AdministradorDTO(String usuario, String contrasenia) {
        super(usuario, contrasenia, "ADMIN");
    }
    
    
}
