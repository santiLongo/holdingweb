package prog2.holdingweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class PaisDAO {
    
    private final String dbFullURL; 
    private final String dbUser; 
    private final String dbPswd;
    
    @Autowired 
    public PaisDAO( 
            @Qualifier("dbName") String dbName, 
            @Qualifier("dbURL")  String dbURL, 
            @Qualifier("dbUser") String dbUser, 
            @Qualifier("dbPswd") String dbPswd) { 
        dbFullURL = "jdbc:mysql://" + dbURL + "/" + dbName; 
        this.dbUser = dbUser; 
        this.dbPswd = dbPswd; 
    }
    
    public PaisDTO cargarPais(int codigo){
        PaisDTO pais = new PaisDTO();
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement(); 
            stmt.execute("SELECT * FROM pais WHERE id = " + codigo + ""); 
            ResultSet rs = stmt.getResultSet(); 
            rs.next();
            pais.setNombre(rs.getString("nombre"));
            pais.setCapital(rs.getString("capital"));
            pais.setCantidadHabitantes(rs.getInt("cantHabitantes"));
            pais.setPbi(rs.getInt("pbi"));
            stmt.close();
            con.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pais;
    }
    
    public ArrayList<PaisDTO> cargarListaPaises(int codigoEmpresa){
        ArrayList<PaisDTO> paises = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement(); 
            stmt.execute("SELECT p.id "
                    + "FROM pais p "
                    + "WHERE p.id IN (SELECT act.idPais "
                    + "FROM actua act "
                    + "WHERE act.idEmpresa = " +codigoEmpresa+ ");"); 
            ResultSet rs = stmt.getResultSet(); 
            while(rs.next()){
                paises.add(cargarPais(rs.getInt(1)));
            }
            stmt.close();
            con.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paises;
    }
    
    public ArrayList<PaisDTO> traerPaises(){
        ArrayList<PaisDTO> paises = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement(); 
            stmt.execute("SELECT p.id"
                    + "FROM pais p"); 
            ResultSet rs = stmt.getResultSet(); 
            while(rs.next()){
                paises.add(cargarPais(rs.getInt(1)));
            }
            stmt.close();
            con.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paises;
    }
    
    public void altaPais(PaisDTO pais){
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement(); 
            stmt.executeUpdate("INSERT INTO `pais`(`nombre`, `capital`, `cantHabitantes`, `pbi`) "
                    + "VALUES ('"+pais.getNombre()+"','"+pais.getCapital()+"','"+pais.getCantidadHabitantes()+"','"+pais.getPbi()+"')");
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
