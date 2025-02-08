package prog2.holdingweb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "vendedor")
@PrimaryKeyJoinColumn(name = "id")
public class VendedorDTO extends UsuarioDTO{
    
    @Column(unique = true, nullable = false)
    private String nombre;
    @Column(unique = true, nullable = false)
    private LocalDate fechaDeEntrada;
    @Column(unique = true, nullable = false)
    private String direccion;
    
    @ManyToOne
    @JoinColumn(name = "idEmpresa", nullable = false)
    private EmpresaDTO empresa;
    
    @ManyToOne
    @JoinColumn(name = "idLider")
    private VendedorDTO lider;
    
    @OneToMany(mappedBy = "lider", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VendedorDTO> reclutas;
    
    protected VendedorDTO(){
    }
    
    public VendedorDTO(Long id, String usuario, String contrasenia, String nombre, String date, String direccion, EmpresaDTO empresa, VendedorDTO lider) {
        super(usuario, contrasenia, "VENDEDOR");
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaDeEntrada = LocalDate.parse(date);
        this.empresa = empresa;
        this.lider = lider;
    }
    
    public VendedorDTO(String usuario, String contrasenia, String nombre, String direccion, VendedorDTO lider) {
        setUsuario(usuario);
        setContrasenia(contrasenia);
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaDeEntrada = LocalDate.now();
        this.empresa = lider.getEmpresa();
        this.lider = lider;
    }
    
    public VendedorDTO(String usuario, String contrasenia, String nombre, String direccion, EmpresaDTO empresa) {
        setUsuario(usuario);
        setContrasenia(contrasenia);
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaDeEntrada = LocalDate.now();
        this.empresa = empresa;
    }

    public List<VendedorDTO> getReclutas() {
        return reclutas;
    }
    
    public void setReclutas(List<VendedorDTO> reclutas) {
        this.reclutas = reclutas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeEntrada() {
        return fechaDeEntrada;
    }

    public void setFechaDeEntrada(String fechaEntrada) {
        this.fechaDeEntrada = LocalDate.parse(fechaEntrada);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public VendedorDTO getLider() {
        return lider;
    }

    public void setLider(VendedorDTO lider) {
        this.lider = lider;
    }
    
}
