
package prog2.holdingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Repository
public class UsuarioDAO {
    
    private final String hibernateDir; 
    private UsuarioDTO usuario;
    @Autowired 
    private VendedorDAO vendedorDAO;
    @Autowired
    private AsesorDAO asesorDAO;
    
    @Autowired 
    public UsuarioDAO(
            @Qualifier("hibernateDir") String hibernateDir) {
        this.hibernateDir = hibernateDir;
    }
    
    public String cargarUsuario(String us, String cont) { 
        String resultado = "";
        SessionFactory sessionFactory = new Configuration()
        .configure(hibernateDir)  
        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            String hql = "FROM UsuarioDTO WHERE usuario = :us AND contrasenia = :cont";
            Query<UsuarioDTO> query = session.createQuery(hql, UsuarioDTO.class);
            query.setParameter("us", us);
            query.setParameter("cont", cont);

            UsuarioDTO usuarioDTO = query.uniqueResult();
            if (usuarioDTO != null) {
                switch (usuarioDTO.getTipo()) {
                    case "ADMIN":
                        usuario = new AdministradorDTO(usuarioDTO.getUsuario(), usuarioDTO.getContrasenia());
                        return "administrador";
                    case "VENDEDOR":
                        usuario = vendedorDAO.cargarVendedor(usuarioDTO.getId());
                        return "vendedor";
                    case "ASESOR":
                        usuario = asesorDAO.cargarAsesor(usuarioDTO.getId());
                        return "asesor";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return resultado; 
   }
    
    
    public UsuarioDTO getUsuario() {
        return usuario;
    }
    
}
