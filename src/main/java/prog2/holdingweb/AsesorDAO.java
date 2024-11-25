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
public class AsesorDAO {
    
    private final String dbFullURL; 
    private final String dbUser; 
    private final String dbPswd;
    @Autowired
    private AreaDAO areaDAO;
    @Autowired
    private EmpresaDAO empresaDAO;
    
    @Autowired 
    public AsesorDAO( 
            @Qualifier("dbName") String dbName, 
            @Qualifier("dbURL")  String dbURL, 
            @Qualifier("dbUser") String dbUser, 
            @Qualifier("dbPswd") String dbPswd) { 
        dbFullURL = "jdbc:mysql://" + dbURL + "/" + dbName; 
        this.dbUser = dbUser; 
        this.dbPswd = dbPswd; 
    }
    
    public AsesorDTO cargarAsesor(int codigo){
        AsesorDTO asesor = new AsesorDTO();
        asesor.setCodigo(codigo);
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement(); 
            stmt.execute("SELECT * FROM asesor WHERE id = " + codigo + ""); 
            ResultSet rs = stmt.getResultSet(); 
            rs.next();
            asesor.setNombre(rs.getString("nombre"));
            asesor.setDireccion(rs.getString("direccion"));
            asesor.setAreas(areaDAO.cargarAreasSoporta(codigo));
            asesor.setAsesora(cargarAsesora(codigo));
            stmt.close();
            con.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asesor;
    }
    
    private ArrayList<AsesorDTO.Asesora> cargarAsesora(int codigoAsesor){
        ArrayList<AsesorDTO.Asesora> asesora = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement(); 
            stmt.execute("SELECT idEmpresa, fechaDeEntrada FROM asesora WHERE idAsesor =" + codigoAsesor + ""); 
            ResultSet rs = stmt.getResultSet(); 
            while (rs.next()) {
                    EmpresaDTO empresa = empresaDAO.cargarEmpresa(rs.getInt("idEmpresa"));
                    AsesorDTO.Asesora a = new AsesorDTO.Asesora(empresa, rs.getString("fechaDeEntrada"));
                    asesora.add(a);
            }
            stmt.close();
            con.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asesora;
    }
    
}
