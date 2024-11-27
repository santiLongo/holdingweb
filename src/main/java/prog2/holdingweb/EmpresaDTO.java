package prog2.holdingweb;

import java.time.LocalDate;
import java.util.ArrayList;


public class EmpresaDTO{
    
    private int codigo;
    private String nombre;
    private int facturacion;
    private int cantVendedores;
    private LocalDate fechaDeEntrada;
    private ArrayList<AreaDTO> areas;
    private ArrayList<PaisDTO> paises;
    private PaisDTO sedeCentral;
    
    public EmpresaDTO(String nombre, int facturacion, ArrayList<AreaDTO> areas, ArrayList<PaisDTO> paises, PaisDTO sedeCentral){
        this.nombre = nombre;
        this.facturacion = facturacion;
        this.areas = areas;
        this.paises = paises;
        this.sedeCentral = sedeCentral;
        this.cantVendedores = 0;
        this.fechaDeEntrada = LocalDate.now();
    }

    public EmpresaDTO(){
        this.areas = new ArrayList<>();
        this.paises = new ArrayList<>();
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

    public ArrayList<AreaDTO> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<AreaDTO> areas) {
        this.areas = areas;
    }

    public ArrayList<PaisDTO> getPaises() {
        return paises;
    }

    public void setPaises(ArrayList<PaisDTO> paises) {
        this.paises = paises;
    }

    public PaisDTO getSedeCentral() {
        return sedeCentral;
    }

    public void setSedeCentral(PaisDTO sedeCentral) {
        this.sedeCentral = sedeCentral;
    }
    
    
    
}