package prog2.holdingweb;

import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Repository
public class AdministradorDAO {
    
    private final String hibernateDir;

    @Autowired
    public AdministradorDAO(
            @Qualifier("hibernateDir") String hibernateDir) {
        this.hibernateDir = hibernateDir;
    }

    public boolean existe() {
        List<AdministradorDTO> lista = null;
        SessionFactory sessionFactory = new Configuration()
                .configure(hibernateDir)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            lista = session.createQuery("FROM AdministradorDTO", AdministradorDTO.class)
                    .setMaxResults(1) // Solo trae 1 administrador si existe
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        boolean existe = !lista.isEmpty();
        return existe;
    }

    public void darAlta(String usuario, String contrasenia) { //Ya funciona con hibernate

        SessionFactory sessionFactory = new Configuration()
                .configure(hibernateDir)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            AdministradorDTO admin = new AdministradorDTO(usuario, contrasenia);
            session.save(admin);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
