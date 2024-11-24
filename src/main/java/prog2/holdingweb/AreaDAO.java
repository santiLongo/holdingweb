/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class AreaDAO {
    
    private final String dbFullURL; 
    private final String dbUser; 
    private final String dbPswd;
    
    @Autowired 
    public AreaDAO( 
            @Qualifier("dbName") String dbName, 
            @Qualifier("dbURL")  String dbURL, 
            @Qualifier("dbUser") String dbUser, 
            @Qualifier("dbPswd") String dbPswd) { 
        dbFullURL = "jdbc:mysql://" + dbURL + "/" + dbName; 
        this.dbUser = dbUser; 
        this.dbPswd = dbPswd; 
    }
    
    private AreaDTO cargarArea(int codigo){
        AreaDTO area = new AreaDTO();
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement(); 
            stmt.execute("SELECT * "
                    + "FROM area a "
                    + "WHERE a.id = " +codigo+ ");"); 
            ResultSet rs = stmt.getResultSet(); 
            rs.next();
            area.setNombre(rs.getString("nombre"));
            area.setDescripcion(rs.getString("descripcion"));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return area;
    }
    
    public ArrayList<AreaDTO> cargarAreasSoporta(int codigoAsesor){
        ArrayList<AreaDTO> areas = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement(); 
            stmt.execute("SELECT a.id "
                    + "FROM area a "
                    + "WHERE a.id IN (SELECT s.idArea "
                    + "FROM soporta s "
                    + "WHERE s.idAsesor = " +codigoAsesor+ ");"); 
            ResultSet rs = stmt.getResultSet(); 
            while(rs.next()){
                areas.add(cargarArea(rs.getInt(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return areas;
    }
    
    public ArrayList<AreaDTO> cargarAreasCubre(int codigoEmpresa){
        ArrayList<AreaDTO> areas = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement(); 
            stmt.execute("SELECT a.id "
                    + "FROM area a "
                    + "WHERE a.id IN (SELECT c.idArea "
                    + "FROM cubre c "
                    + "WHERE c.idEmpresa = " +codigoEmpresa+ ");"); 
            ResultSet rs = stmt.getResultSet(); 
            while(rs.next()){
                areas.add(cargarArea(rs.getInt(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return areas;
    }
}
