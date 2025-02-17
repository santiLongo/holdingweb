package prog2.holdingweb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "asesor")
@PrimaryKeyJoinColumn(name = "id")
public class AsesorDTO extends UsuarioDTO{
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "direccion",nullable = false)
    private String direccion;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "soporta",
        joinColumns = @JoinColumn(name = "idAsesor"),
        inverseJoinColumns = @JoinColumn(name = "idArea")
    )
    private List<AreaDTO> areas;
    
    @OneToMany(mappedBy = "asesor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<AsesoraDTO> asesoramientos;

    
    public AsesorDTO(String usuario,String contrasenia, String nombre, String direccion, List<AreaDTO> areas, List<EmpresaDTO> empresas){
        super(usuario, contrasenia, "ASESOR");
        this.nombre = nombre;
        this.direccion = direccion;
        this.areas = areas;
        for(EmpresaDTO empresa: empresas){
            AsesoraDTO asesoramiento = new AsesoraDTO(empresa, this);
            this.asesoramientos.add(asesoramiento);
        }
    }
    
    protected AsesorDTO(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<AsesoraDTO> getAsesoramientos() {
        return asesoramientos;
    }

    public void setAsesoramientos(List<AsesoraDTO> asesoramientos) {
        this.asesoramientos = asesoramientos;
    }

    public List<AreaDTO> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaDTO> areas) {
        this.areas = areas;
    }
    
    
}
