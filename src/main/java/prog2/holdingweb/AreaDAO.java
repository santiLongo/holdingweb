package prog2.holdingweb;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;



@Repository
public class AreaDAO {
    
    private final String hibernateDir;
    
    @Autowired 
    public AreaDAO(
            @Qualifier("hibernateDir") String hibernateDir) {
        this.hibernateDir = hibernateDir;
    }
    
    private AreaDTO cargarArea(Long id){
        AreaDTO area = new AreaDTO();
        SessionFactory sessionFactory = new Configuration()
        .configure(hibernateDir)  
        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            area = session.find(AreaDTO.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return area;
    }
    
    public List<AreaDTO> traerAreas(){
        List<AreaDTO> areas = null;
        SessionFactory sessionFactory = new Configuration()
        .configure(hibernateDir)  
        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            areas = session.createQuery("FROM AreaDTO", AreaDTO.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return areas;
    }
    
    public void altaArea(AreaDTO area){
        SessionFactory sessionFactory = new Configuration()
        .configure(hibernateDir)  
        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(area);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
}