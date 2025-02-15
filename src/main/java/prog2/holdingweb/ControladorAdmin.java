package prog2.holdingweb;

import java.util.List;
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
        
        System.out.println(nombre);
        System.out.println(facturacion);
        List<AreaDTO> areas = areaDAO.cargarAreas(areasId);
        List<PaisDTO> paises = paisDAO.cargarPaises(paisesId);
        PaisDTO sedeCentral = paisDAO.cargarPais(sedeCentralId);
        System.out.println("Sede");
        System.out.println(sedeCentral.getNombre());
        System.out.println("Areas");
        for(AreaDTO area : areas){
            System.out.println(area.getNombre());
        }
        System.out.println("Paises");
        for(PaisDTO pais: paises){
            System.out.println(pais.getNombre());
        }
        
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
            @RequestParam(value = "areas", required = true) List<AreaDTO> areas,
            @RequestParam(value = "empresas", required = true) List<EmpresaDTO> empresas){
        
       // List<AsesorDTO.Asesora> asesora = AsesorDTO.Asesora.crearLista(empresas);
       // AsesorDTO asesor = new AsesorDTO(nombre, direccion, areas, asesora);
        //asesorDAO.altaAsesor(asesor);
       // model.addAttribute("asesor", asesor);
        return "asesor";
    }
    
    @GetMapping("/inicio/altaVendedor")
    public String crearVendedor(Model model){
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
            @RequestParam(value = "lider", required = true) VendedorDTO lider,
            @RequestParam(value = "empresa", required = true) EmpresaDTO empresa){
        
        VendedorDTO vendedor;
        if(lider.getId() == 0){
            vendedor = new VendedorDTO(usuario, contrasenia, nombre, direccion, empresa);
        }else vendedor = new VendedorDTO(usuario, contrasenia, nombre, direccion, lider);
        
        vendedorDAO.altaVendedor(vendedor);
        model.addAttribute("vendedor", vendedor);
        return "vendedor";
    }
}
