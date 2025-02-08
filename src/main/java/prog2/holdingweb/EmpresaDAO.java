
package prog2.holdingweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class EmpresaDAO {
    
    private final String hibernateDir;
    private final String dbFullURL; 
    private final String dbUser; 
    private final String dbPswd;
    @Autowired
    private PaisDAO paisDAO;
    @Autowired
    private VendedorDAO vendedorDAO;
    @Autowired
    private AreaDAO areaDAO;
    
    @Autowired 
    public EmpresaDAO( 
            @Qualifier("dbName") String dbName, 
            @Qualifier("dbURL")  String dbURL, 
            @Qualifier("dbUser") String dbUser, 
            @Qualifier("dbPswd") String dbPswd,
            @Qualifier("hibernateDir") String hibernateDir) { 
        dbFullURL = "jdbc:mysql://" + dbURL + "/" + dbName; 
        this.dbUser = dbUser; 
        this.dbPswd = dbPswd;
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
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return empresa;
    }
    
    public void altaEmpresa(EmpresaDTO empresa){
        
    }
}
