package prog2.holdingweb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
    
    @ManyToMany
    @JoinTable(
        name = "soporta",
        joinColumns = @JoinColumn(name = "idAsesor"),
        inverseJoinColumns = @JoinColumn(name = "idArea")
    )
    private List<AreaDTO> areas;
    
    @ManyToMany
    @JoinTable(
        name = "asesora",
        joinColumns = @JoinColumn(name = "idAsesor"),
        inverseJoinColumns = @JoinColumn(name = "idEmpresa")
    )
    private List<EmpresaDTO> empresas;
    
    public AsesorDTO(String usuario,String contrasenia, String nombre, String direccion, List<AreaDTO> areas, List<EmpresaDTO> empresas){
        super(usuario, contrasenia, "ASESOR");
        this.nombre = nombre;
        this.direccion = direccion;
        this.areas = areas;
        this.empresas = empresas;
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

    public List<EmpresaDTO> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<EmpresaDTO> empresas) {
        this.empresas = empresas;
    }

    

    public List<AreaDTO> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaDTO> areas) {
        this.areas = areas;
    }
    
    
}
