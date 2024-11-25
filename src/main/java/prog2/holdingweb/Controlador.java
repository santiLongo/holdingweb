package prog2.holdingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Importación correcta de Model
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {

    @Autowired 
    private UsuarioDAO usuarioDAO;
    @Autowired
    private AdministradorDAO adminDAO;

    @GetMapping("/")
    public String mostrarInicio() {
        if(!adminDAO.existe()){
            return "altaAdmin";// vista dar de alta admin
        }
        return "index"; // Vista en /vistas/index.jsp
    }
    
    @PostMapping("/")
    public String altaAdministrador(@RequestParam(value = "usuarioAdmin", required = true) String usuarioAdmin,
                                    @RequestParam(value = "contraseniaAdmin", required = true) String contraseniaAdmin){
        adminDAO.darAlta(usuarioAdmin, contraseniaAdmin);
        return "index";
    }

    @PostMapping("/inicio")
    public String mostrarUsuario(
            Model model,
            @RequestParam(value = "usuario", required = true) String usuario,
            @RequestParam(value = "contrasenia", required = true) String contrasenia) {
        String tipoUser = usuarioDAO.getTipoUsuario(usuario, contrasenia);
        model.addAttribute("usuario", usuarioDAO.getUsuario()); // Agregar datos al modelo
        
        if(tipoUser.equals("")){
            return "errorUsuario";
        }
        return tipoUser;
    }
}