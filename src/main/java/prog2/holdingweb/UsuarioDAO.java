
package prog2.holdingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class UsuarioDAO {
    
    private final String dbFullURL; 
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
            @Qualifier("dbPswd") String dbPswd) { 
        dbFullURL = "jdbc:mysql://" + dbURL + "/" + dbName; 
        this.dbUser = dbUser; 
        this.dbPswd = dbPswd; 
    }
    
    public String getTipoUsuario(String us, String cont) { 
       String resultado = "";
       try { 
           Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd); 
           Statement stmt = con.createStatement(); 
           stmt.execute("SELECT 'administrador' AS tipo_usuario, administrador.id\n" +
                        "FROM administrador\n" +
                        "WHERE usuario = '"+us+"' AND contrasenia = '"+cont+"'\n" +
                        "\n" +
                        "UNION ALL\n" +
                        "\n" +
                        "SELECT 'vendedor' AS tipo_usuario, vendedor.id\n" +
                        "FROM vendedor\n" +
                        "WHERE usuario = '"+us+"' AND contrasenia = '"+cont+"'\n" +
                        "\n" +
                        "UNION ALL\n" +
                        "\n" +
                        "SELECT 'asesor' AS tipo_usuario, asesor.id\n" +
                        "FROM asesor\n" +
                        "WHERE usuario = '"+us+"' AND contrasenia = '"+cont+"';"); 
           ResultSet rs = stmt.getResultSet(); 
           if(rs.next()){
               resultado = rs.getString("tipo_usuario");
               cargarUsuario(rs.getString(1),rs.getInt("id"));
           } 
           con.close(); 
       } catch (SQLException e) { 
           System.err.println(e.getMessage()); 
       } 
       return resultado; 
   }
    
   private void cargarUsuario(String tipo, int codigo){
       try { 
           Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd); 
           Statement stmt = con.createStatement(); 
           stmt.execute("SELECT * FROM " + tipo + " WHERE id = " + codigo + ""); 
           ResultSet rs = stmt.getResultSet(); 
           rs.next();
           switch (tipo){
               case "administrador":
                   this.usuario = new AdministradorDTO(rs.getString("usuario"),rs.getString("contrasenia"));
                   break;
               case "vendedor":
                   this.usuario = vendedorDAO.cargarVendedor(codigo);
                   break;
               case "asesor":
                   this.usuario = asesorDAO.cargarAsesor(codigo);
                   break;
           }
           con.close(); 
       } catch (SQLException e) { 
           System.err.println(e.getMessage()); 
       } 
   }

    public UsuarioDTO getUsuario() {
        return usuario;
    }
    
}
