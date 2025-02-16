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
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "soporta",
        joinColumns = @JoinColumn(name = "idAsesor"),
        inverseJoinColumns = @JoinColumn(name = "idArea")
    )
    private List<AreaDTO> areas;
    
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "asesora", 
        joinColumns = @JoinColumn(name = "idAsesor"))
    private Set<Asesora> asesora;
    
    public AsesorDTO(String usuario,String contrasenia, String nombre, String direccion, List<AreaDTO> areas, Set<Asesora> asesora){
        super(usuario, contrasenia, "ASESOR");
        this.nombre = nombre;
        this.direccion = direccion;
        this.areas = areas;
        this.asesora = asesora;
    }
    
    protected AsesorDTO(){
    }
    
    @Embeddable
    public static class Asesora{
        
        @ManyToOne
        @JoinColumn(name = "idEmpresa", nullable = false)
        private EmpresaDTO empresa;
        
        @Column(name = "fechaDeEntrada", nullable = false)
        private LocalDate fechaDeEntrada;
        
        public Asesora(EmpresaDTO empresa){
            this.empresa = empresa;
            this.fechaDeEntrada = LocalDate.now();
        }
        
        protected Asesora(){ 
        }

        public EmpresaDTO getEmpresa() {
            return empresa;
        }

        public LocalDate getFechaDeEntrada() {
            return fechaDeEntrada;
        }
        
        public static Set<Asesora> crearLista(List<EmpresaDTO> empresas){
            Set<Asesora> asesora = new HashSet<>();
            for(EmpresaDTO empresa : empresas){
                asesora.add(new Asesora(empresa));
            }
            return asesora;
        }
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

    public Set<Asesora> getAsesora() {
        return asesora;
    }

    public void setAsesora(Set<Asesora> asesora) {
        this.asesora = asesora;
    }

    public List<AreaDTO> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaDTO> areas) {
        this.areas = areas;
    }
    
    
}
