
package prog2.holdingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Repository
public class UsuarioDAO {
    
    private final String dbFullURL;
    private final String hibernateDir;
    private final String dbUser; 
    private final String dbPswd; 
    private UsuarioDTO usuario;
    @Autowired 
    private VendedorDAO vendedorDAO;
    @Autowired
    private AsesorDAO asesorDAO;
    
    @Autowired 
    public UsuarioDAO( 
            @Qualifier("dbName") String dbName, 
            @Qualifier("dbURL")  String dbURL, 
            @Qualifier("dbUser") String dbUser,
            @Qualifier("hibernateDir") String hibernateDir,
            @Qualifier("dbPswd") String dbPswd) { 
        dbFullURL = "jdbc:mysql://" + dbURL + "/" + dbName; 
        this.dbUser = dbUser; 
        this.dbPswd = dbPswd; 
        this.hibernateDir = hibernateDir;

    }
    
    public String cargarUsuario(String us, String cont) { 
       String resultado = "";
       try { 
           Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd); 
           Statement stmt = con.createStatement(); 
           stmt.execute("SELECT * FROM `usuario` WHERE usuario = '" + us + "' AND contrasenia = '" + cont +"'"); 
           ResultSet rs = stmt.getResultSet(); 
           rs.next();
           switch (rs.getString("tipo")){
               case "ADMIN":
                   resultado = "administrador";
                   this.usuario = new AdministradorDTO(rs.getString(2),rs.getString(3));
                   break;
               case "VENDEDOR":
                   resultado = "vendedor";
                   this.usuario = vendedorDAO.cargarVendedor(rs.getInt("id"));
                   break;
               case "ASESOR":
                   resultado = "asesor";
                   this.usuario = asesorDAO.cargarAsesor(rs.getInt("id"));
                   break;
           }
           con.close();
           stmt.close();
           con.close();
           rs.close();
       } catch (SQLException e) { 
           System.err.println(e.getMessage()); 
       }  
       return resultado; 
   }
   
   public void darAlta(String usuario, String contrasenia){
        
        SessionFactory sessionFactory = new 
        Configuration().configure(hibernateDir).addAnnotatedClass(UsuarioDTO.class).buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        try{
            
            //usuario = new UsuarioDTO()
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }
    
}
