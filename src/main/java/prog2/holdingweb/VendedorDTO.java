package prog2.holdingweb;

import java.time.LocalDate;
import java.util.ArrayList;

public class VendedorDTO extends UsuarioDTO{
    
    private String nombre;
    private LocalDate fechaEntrada;
    private int codigo;
    private String direccion;
    private EmpresaDTO empresa;
    private VendedorDTO lider;
    private ArrayList<VendedorDTO> reclutas;
    
    public VendedorDTO(){
        this.reclutas = new ArrayList<>();
    }
    
    public VendedorDTO(int codigo, String usuario, String contrasenia, String nombre, String date, String direccion, EmpresaDTO empresa, VendedorDTO lider) {
        setUs(usuario);
        setContraseña(contrasenia);
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaEntrada = LocalDate.parse(date);
        this.empresa = empresa;
        this.lider = lider;
    }
    
    public VendedorDTO(int codigo, String usuario, String contrasenia, String nombre, String direccion, EmpresaDTO empresa, VendedorDTO lider) {
        setUs(usuario);
        setContraseña(contrasenia);
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaEntrada = LocalDate.now();
        this.empresa = empresa;
        this.lider = lider;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
