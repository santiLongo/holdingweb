package prog2.holdingweb;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class EmpresaDAO {
    
    private final String hibernateDir;
    @Autowired
    private PaisDAO paisDAO;
    @Autowired
    private VendedorDAO vendedorDAO;
    @Autowired
    private AreaDAO areaDAO;
    
    @Autowired 
    public EmpresaDAO(
            @Qualifier("hibernateDir") String hibernateDir) {
        this.hibernateDir = hibernateDir;
    }
    
    public EmpresaDTO cargarEmpresa(Long id){
        EmpresaDTO empresa = new EmpresaDTO();
        SessionFactory sessionFactory = new Configuration()
        .configure(hibernateDir)  
        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            empresa = session.find(EmpresaDTO.class, id);
            if (empresa != null) {
                Hibernate.initialize(empresa.getPaises());
                Hibernate.initialize(empresa.getAreas());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return empresa;
    }
    
    public List<EmpresaDTO> cargarEmpresas(List<Long> ids){
        List<EmpresaDTO> empresas = new ArrayList<>();
        SessionFactory sessionFactory = new Configuration()
        .configure(hibernateDir)  
        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            for(Long id: ids){
            empresas.add(session.find(EmpresaDTO.class, id));
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return empresas;
    }
    
    public List<EmpresaDTO> traerEmpresas(){
        List<EmpresaDTO> empresas = null;
        SessionFactory sessionFactory = new Configuration()
        .configure(hibernateDir)  
        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            empresas = session.createQuery("FROM EmpresaDTO", EmpresaDTO.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return empresas;
    }
    
    public void altaEmpresa(EmpresaDTO empresa){
        SessionFactory sessionFactory = new Configuration()
        .configure(hibernateDir)  
        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.save(empresa);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
