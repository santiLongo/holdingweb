package prog2.holdingweb;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorAdmin{
    
    @Autowired
    private AdministradorDAO adminDAO;
    @Autowired
    private VendedorDAO vendedorDAO;
    @Autowired
    private AsesorDAO asesorDAO;
    @Autowired
    private PaisDAO paisDAO;
    @Autowired
    private EmpresaDAO empresaDAO;
    @Autowired
    private AreaDAO areaDAO;
    
    @GetMapping("/inicio/pais")
    public String crearPais(){
        return "altaPais";
    }
    
    @PostMapping("/inicio/pais")
    public String altaPais(Model model,
            @RequestParam(value = "nombre", required = true) String nombre,
            @RequestParam(value = "capital", required = true) String capital,
            @RequestParam(value = "pbi", required = true) int pbi,
            @RequestParam(value = "cantidadHabitantes", required = true) int cantidadHabitantes){
        
        PaisDTO pais = new PaisDTO(nombre,capital,pbi,cantidadHabitantes);
        paisDAO.altaPais(pais);
        model.addAttribute("pais", pais);
        return "pais";
    }
    
    @GetMapping("/inicio/area")
    public String crearArea(){
        return "altaArea";
    }
    
    @PostMapping("/inicio/area")
    public String altaArea(Model model,
            @RequestParam(value = "nombre", required = true) String nombre,
            @RequestParam(value = "descripcion", required = true) String descripcion){
        
        AreaDTO area = new AreaDTO(nombre,descripcion);
        areaDAO.altaArea(area);
        model.addAttribute("area", area);
        return "area";
    }
    
    @GetMapping("/inicio/empresa")
    public String crearEmpresa(Model model){
        model.addAttribute("paises", paisDAO.traerPaises());
        model.addAttribute("areas", areaDAO.traerAreas());
        return "altaEmpresa";
    }
    
    @PostMapping("/inicio/empresa")
    public String altaEmpresa(Model model,
            @RequestParam(value = "nombre", required = true) String nombre,
            @RequestParam(value = "facturacion", required = true) int facturacion,
            @RequestParam(value = "sedeCentral", required = true) PaisDTO sedeCentral,
            @RequestParam(value = "areas", required = true) ArrayList<AreaDTO> areas,
            @RequestParam(value = "paises", required = true) ArrayList<PaisDTO> paises){
        
        EmpresaDTO empresa = new EmpresaDTO(nombre,facturacion,areas,paises,sedeCentral);
        empresaDAO.altaEmpresa(empresa);
        model.addAttribute("empresa", empresa);
        return "empresa";
    }
    
    @GetMapping("/inicio/asesor")
    public String crearAsesor(Model model){
        model.addAttribute("empresas", empresaDAO.traerEmpresas());
        model.addAttribute("areas", areaDAO.traerAreas());
        return "altaAsesor";
    }
    
    @PostMapping("/inicio/asesor")
    public String altaAsesor(Model model,
            @RequestParam(value = "usuario", required = true) String usuario,
            @RequestParam(value = "contrasenia", required = true) String contrasenia,
            @RequestParam(value = "nombre", required = true) String nombre,
            @RequestParam(value = "direccion", required = true) String direccion,
            @RequestParam(value = "areas", required = true) ArrayList<AreaDTO> areas,
            @RequestParam(value = "empresas", required = true) ArrayList<EmpresaDTO> empresas){
        
        ArrayList<AsesorDTO.Asesora> asesora = AsesorDTO.Asesora.crearLista(empresas);
        AsesorDTO asesor = new AsesorDTO(usuario, contrasenia, nombre, direccion, areas, asesora);
        asesorDAO.altaAsesor(asesor);
        model.addAttribute("asesor", asesor);
        return "asesor";
    }
    
    @GetMapping("/inicio/vendedor")
    public String crearVendedor(Model model){
        model.addAttribute("empresas", empresaDAO.traerEmpresas());
        model.addAttribute("vendedores", vendedorDAO.traerVendedores());
        return "altaVendedor";
    }
    
    @PostMapping("/inicio/vendedor")
    public String altaVendedor(Model model,
            @RequestParam(value = "usuario", required = true) String usuario,
            @RequestParam(value = "contrasenia", required = true) String contrasenia,
            @RequestParam(value = "nombre", required = true) String nombre,
            @RequestParam(value = "direccion", required = true) String direccion,
            @RequestParam(value = "lider", required = true) VendedorDTO lider,
            @RequestParam(value = "empresa", required = true) EmpresaDTO empresa){
        
        VendedorDTO vendedor;
        if(lider.getCodigo() == 0){
            vendedor = new VendedorDTO(usuario, contrasenia, nombre, direccion, empresa);
        }else vendedor = new VendedorDTO(usuario, contrasenia, nombre, direccion, lider);
        
        vendedorDAO.altaVendedor(vendedor);
        model.addAttribute("vendedor", vendedor);
        return "vendedor";
    }
}
