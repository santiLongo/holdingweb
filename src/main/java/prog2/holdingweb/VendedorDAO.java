package prog2.holdingweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class VendedorDAO {
    
    private final String hibernateDir;
    @Autowired
    private EmpresaDAO empresaDAO;
    
    @Autowired 
    public VendedorDAO(
            @Qualifier("hibernateDir") String hibernateDir) {
        this.hibernateDir = hibernateDir;
    }
    
    public VendedorDTO cargarVendedor(Long id){
        VendedorDTO vendedor = new VendedorDTO();
        SessionFactory sessionFactory = new Configuration()
        .configure(hibernateDir)  
        .buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            vendedor = session.find(VendedorDTO.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return vendedor;
    }
    
    public void altaVendedor(VendedorDTO vendedor){
        
    }
}
