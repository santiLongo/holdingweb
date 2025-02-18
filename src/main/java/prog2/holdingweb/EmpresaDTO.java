package prog2.holdingweb;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "empresa")
public class EmpresaDTO{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private int facturacion;
    
    @Column(nullable = false)
    private LocalDate fechaDeEntrada;
    
    @ManyToMany
    @JoinTable(
        name = "cubre",
        joinColumns = @JoinColumn(name = "idEmpresa"),
        inverseJoinColumns = @JoinColumn(name = "idArea")
    )
    private List<AreaDTO> areas;
    
    @ManyToMany
    @JoinTable(
        name = "actua",
        joinColumns = @JoinColumn(name = "idEmpresa"),
        inverseJoinColumns = @JoinColumn(name = "idPais")
    )
    private List<PaisDTO> paises;
    
    @ManyToOne
    @JoinColumn(name = "idPaisSede")
    private PaisDTO sedeCentral;
    
    @Formula("(SELECT COUNT(v.id) FROM vendedor v WHERE v.idEmpresa = id)")
    private int cantVendedores;
    
    public EmpresaDTO(String nombre, int facturacion, List<AreaDTO> areas, List<PaisDTO> paises, PaisDTO sedeCentral){
        this.nombre = nombre;
        this.facturacion = facturacion;
        this.areas = areas;
        this.paises = paises;
        this.sedeCentral = sedeCentral;
        this.fechaDeEntrada = LocalDate.now();
    }

    public EmpresaDTO(){
        this.areas = null;
        this.paises = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long codigo) {
        this.id = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(int facturacion) {
        this.facturacion = facturacion;
    }

    public int getCantVendedores() {
        return cantVendedores;
    }

    public void setCantVendedores(int cantVendedores) {
        this.cantVendedores = cantVendedores;
    }

    public LocalDate getFechaDeEntrada() {
        return fechaDeEntrada;
    }

    public void setFechaDeEntrada(String fechaDeEntrada) {
        this.fechaDeEntrada = LocalDate.parse(fechaDeEntrada);
    }

    public List<AreaDTO> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaDTO> areas) {
        this.areas = areas;
    }

    public List<PaisDTO> getPaises() {
        return paises;
    }

    public void setPaises(List<PaisDTO> paises) {
        this.paises = paises;
    }

    public PaisDTO getSedeCentral() {
        return sedeCentral;
    }

    public void setSedeCentral(PaisDTO sedeCentral) {
        this.sedeCentral = sedeCentral;
    }
    
    
    
}