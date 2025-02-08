package prog2.holdingweb;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.springframework.stereotype.Repository;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "asesor")
@PrimaryKeyJoinColumn(name = "id")
public class AsesorDTO extends UsuarioDTO{
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String direccion;
    
    @ManyToMany
    @JoinTable(
        name = "soporta",
        joinColumns = @JoinColumn(name = "idAsesor"),
        inverseJoinColumns = @JoinColumn(name = "idArea")
    )
    private ArrayList<AreaDTO> areas;
    
    @ElementCollection
    @CollectionTable(name = "asesora", 
        joinColumns = @JoinColumn(name = "idAsesor"))
    private ArrayList<Asesora> asesora;
    
    public AsesorDTO(String nombre, String direccion, ArrayList<AreaDTO> areas, ArrayList<Asesora> asesora){
        
        this.nombre = nombre;
        this.direccion = direccion;
        this.areas = areas;
        this.asesora = asesora;
    }
    
    public AsesorDTO(){
        this.areas = new ArrayList<>();
        this.asesora = new ArrayList<>();
    }
    
    @Embeddable
    public static class Asesora{
        
        @ManyToOne
        @JoinColumn(name = "idEmpresa", nullable = false)
        private EmpresaDTO empresa;
        
        @Column(nullable = false)
        private LocalDate fechaEntrada;
        
        public Asesora(EmpresaDTO empresa){
            this.empresa = empresa;
            this.fechaEntrada = LocalDate.now();
        }
        
        protected Asesora(){ 
        }

        public EmpresaDTO getEmpresa() {
            return empresa;
        }

        public LocalDate getFechaEntrada() {
            return fechaEntrada;
        }
        
        public static ArrayList<Asesora> crearLista(ArrayList<EmpresaDTO> empresas){
            ArrayList<Asesora> asesora = new ArrayList<>();
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

    public ArrayList<Asesora> getAsesora() {
        return asesora;
    }

    public void setAsesora(ArrayList<Asesora> asesora) {
        this.asesora = asesora;
    }

    public ArrayList<AreaDTO> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<AreaDTO> areas) {
        this.areas = areas;
    }
    
    
}
