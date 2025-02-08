package prog2.holdingweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

@Repository
public class AdministradorDAO {

    private final String dbFullURL;
    private final String hibernateDir;
    private final String dbUser;
    private final String dbPswd;

    @Autowired
    public AdministradorDAO(
            @Qualifier("dbName") String dbName,
            @Qualifier("dbURL") String dbURL,
            @Qualifier("dbUser") String dbUser,
            @Qualifier("hibernateDir") String hibernateDir,
            @Qualifier("dbPswd") String dbPswd) {
        dbFullURL = "jdbc:mysql://" + dbURL + "/" + dbName;
        this.dbUser = dbUser;
        this.dbPswd = dbPswd;
        this.hibernateDir = hibernateDir;
    }

    public boolean existe() {
        boolean existe = false;
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement(); 
            stmt.execute("SELECT * FROM administrador"); 
            ResultSet rs = stmt.getResultSet(); 
            if(rs.next()){
                existe = true;
            }
            stmt.close();
            con.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
