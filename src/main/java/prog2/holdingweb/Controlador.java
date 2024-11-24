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

    @GetMapping("/")
    public String mostrarInicio() {
        return "index"; // Vista en /vistas/index.jsp
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