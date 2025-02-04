package prog2.holdingweb;

import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

public class AsesorDTO extends UsuarioDTO{
    
    private int codigo;
    private String nombre;
    private String direccion;
    private ArrayList<AreaDTO> areas;
    private ArrayList<Asesora> asesora;
    
    public AsesorDTO(String usuario, String contrasenia, String nombre, String direccion, ArrayList<AreaDTO> areas, ArrayList<Asesora> asesora){
        setUsuario(usuario);
        setContrasenia(contrasenia);
        this.nombre = nombre;
        this.direccion = direccion;
        this.areas = areas;
        this.asesora = asesora;
    }
    
    public AsesorDTO(){
        this.areas = new ArrayList<>();
        this.asesora = new ArrayList<>();
    }
    
    public static class Asesora{
        
        private EmpresaDTO empresa;
        private LocalDate fechaEntrada;
        
        public Asesora(EmpresaDTO empresa){
            this.empresa = empresa;
            this.fechaEntrada = LocalDate.now();
        }
        
        public Asesora(EmpresaDTO empresa, String fechaEntrada){
            this.empresa = empresa;
            this.fechaEntrada = LocalDate.parse(fechaEntrada);
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
