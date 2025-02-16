package prog2.holdingweb;

import java.util.List;
import java.util.Set;
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
    
    @GetMapping("/inicio/altaPais")
    public String crearPais(){
        return "altaPais";
    }
    
    @PostMapping("/inicio/altaPais")
    public String altaPais(Model model,
            @RequestParam(value = "nombre", required = true) String nombre,
            @RequestParam(value = "capital", required = true) String capital,
            @RequestParam(value = "pbi", required = true) int pbi,
            @RequestParam(value = "cantidadHabitantes", required = true) int cantidadHabitantes){
        
        PaisDTO pais = new PaisDTO(nombre,capital,pbi,cantidadHabitantes);
        paisDAO.altaPais(pais);
        return "administrador";
    }
    
    @GetMapping("/inicio/altaArea")
    public String crearArea(){
        return "altaArea";
    }
    
    @PostMapping("/inicio/altaArea")
    public String altaArea(Model model,
            @RequestParam(value = "nombre", required = true) String nombre,
            @RequestParam(value = "descripcion", required = true) String descripcion){
        
        AreaDTO area = new AreaDTO(nombre,descripcion);
        areaDAO.altaArea(area);
        return "administrador";
    }
    
    @GetMapping("/inicio/altaEmpresa")
    public String crearEmpresa(Model model){
        model.addAttribute("paises", paisDAO.traerPaises());
        model.addAttribute("areas", areaDAO.traerAreas());
        return "altaEmpresa";
    }
    
    @PostMapping("/inicio/altaEmpresa")
    public String altaEmpresa(Model model,
            @RequestParam(value = "nombre", required = true) String nombre,
            @RequestParam(value = "facturacion", required = true) int facturacion,
            @RequestParam(value = "sedeCentral", required = true) Long sedeCentralId,
            @RequestParam(value = "areas", required = false) List<Long> areasId,
            @RequestParam(value = "paises", required = false) List<Long> paisesId){
        
        List<AreaDTO> areas = areaDAO.cargarAreas(areasId);
        List<PaisDTO> paises = paisDAO.cargarPaises(paisesId);
        PaisDTO sedeCentral = paisDAO.cargarPais(sedeCentralId);
        
        EmpresaDTO empresa = new EmpresaDTO(nombre,facturacion,areas,paises,sedeCentral);
        empresaDAO.altaEmpresa(empresa);
        return "administrador";
    }
    
    @GetMapping("/inicio/altaAsesor")
    public String crearAsesor(Model model){
        model.addAttribute("empresas", empresaDAO.traerEmpresas());
        model.addAttribute("areas", areaDAO.traerAreas());
        return "altaAsesor";
    }
    
    @PostMapping("/inicio/altaAsesor")
    public String altaAsesor(Model model,
            @RequestParam(value = "usuario", required = true) String usuario,
            @RequestParam(value = "contrasenia", required = true) String contrasenia,
            @RequestParam(value = "nombre", required = true) String nombre,
            @RequestParam(value = "direccion", required = true) String direccion,
            @RequestParam(value = "areas", required = false) List<Long> areasId,
            @RequestParam(value = "empresas", required = false) List<Long> empresasId){
        
        List<EmpresaDTO> empresas = empresaDAO.cargarEmpresas(empresasId);
        List<AreaDTO> areas = areaDAO.cargarAreas(areasId);
        
        AsesorDTO asesor = new AsesorDTO(usuario, contrasenia, nombre, direccion, areas, empresas);
        asesorDAO.altaAsesor(asesor);
       
        return "administrador";
    }
    
    @GetMapping("/inicio/altaVendedor")
    public String altaVendedor(Model model){
        model.addAttribute("empresas", empresaDAO.traerEmpresas());
        model.addAttribute("vendedores", vendedorDAO.traerVendedores());
        return "altaVendedor";
    }
    
    @PostMapping("/inicio/altaVendedor")
    public String altaVendedor(Model model,
            @RequestParam(value = "usuario", required = true) String usuario,
            @RequestParam(value = "contrasenia", required = true) String contrasenia,
            @RequestParam(value = "nombre", required = true) String nombre,
            @RequestParam(value = "direccion", required = true) String direccion,
            @RequestParam(value = "lider", required = false) Long liderId,
            @RequestParam(value = "empresa", required = false) Long empresaId){
        
        System.out.println(empresaId);
        
        if(liderId == null){
            EmpresaDTO empresa = empresaDAO.cargarEmpresa(empresaId);
            VendedorDTO vendedor = new VendedorDTO(usuario, contrasenia, nombre, direccion, empresa);
            System.out.println(vendedor.getNombre());
            System.out.println(vendedor.getDireccion());
            System.out.println(vendedor.getEmpresa().getNombre());
            vendedorDAO.altaVendedor(vendedor);
        }else {
            VendedorDTO lider = vendedorDAO.cargarVendedor(liderId);
            VendedorDTO vendedor = new VendedorDTO(usuario, contrasenia, nombre, direccion, lider);
            vendedorDAO.altaVendedor(vendedor);
        }
        
        return "administrador";
    }
}
