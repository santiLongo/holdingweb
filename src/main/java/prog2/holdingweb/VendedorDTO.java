package prog2.holdingweb;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class VendedorDTO extends UsuarioDTO{
    
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private UsuarioDTO usuario;
    
    private String nombre;
    private LocalDate fechaEntrada;
    private Long id;
    private String direccion;
    private EmpresaDTO empresa;
    private VendedorDTO lider;
    private ArrayList<VendedorDTO> reclutas;
    
    public VendedorDTO(){
        this.reclutas = new ArrayList<>();
    }
    
    public VendedorDTO(Long id, String usuario, String contrasenia, String nombre, String date, String direccion, EmpresaDTO empresa, VendedorDTO lider) {
        super(usuario, contrasenia, "VENDEDOR");
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaEntrada = LocalDate.parse(date);
        this.empresa = empresa;
        this.lider = lider;
    }
    
    public VendedorDTO(String usuario, String contrasenia, String nombre, String direccion, VendedorDTO lider) {
        setUsuario(usuario);
        setContrasenia(contrasenia);
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaEntrada = LocalDate.now();
        this.empresa = lider.getEmpresa();
        this.lider = lider;
    }
    
    public VendedorDTO(String usuario, String contrasenia, String nombre, String direccion, EmpresaDTO empresa) {
        setUsuario(usuario);
        setContrasenia(contrasenia);
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaEntrada = LocalDate.now();
        this.empresa = empresa;
    }

    public ArrayList<VendedorDTO> getReclutas() {
        return reclutas;
    }
    
    public void setReclutas(ArrayList<VendedorDTO> reclutas) {
        this.reclutas = reclutas;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = LocalDate.parse(fechaEntrada);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long codigo) {
        this.id = id;
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
