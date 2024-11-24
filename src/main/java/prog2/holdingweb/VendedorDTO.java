package prog2.holdingweb;

import java.time.LocalDate;
import java.util.ArrayList;

public class VendedorDTO extends UsuarioDTO{
    
    private String nombre;
    private LocalDate fechaEntrada;
    private int codigo;
    private String direccion;
    private int idEmpresa;
    private int idLider;
    private ArrayList<VendedorDTO> reclutas;
    
    public VendedorDTO(int codigo, String usuario, String contrasenia, String nombre, String date, String direccion, int idEmpresa, int idLider) {
        setUs(usuario);
        setContraseña(contrasenia);
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaEntrada = LocalDate.parse(date);
        this.idEmpresa = idEmpresa;
        this.idLider = idLider;
    }
    
    public VendedorDTO(int codigo, String usuario, String contrasenia, String nombre, String direccion, int idEmpresa, int idLider) {
        setUs(usuario);
        setContraseña(contrasenia);
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaEntrada = LocalDate.now();
        this.idEmpresa = idEmpresa;
        this.idLider = idLider;
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

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
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

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdLider() {
        return idLider;
    }

    public void setIdLider(int idLider) {
        this.idLider = idLider;
    }
    
    
}
