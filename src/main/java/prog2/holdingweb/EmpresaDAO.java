
package prog2.holdingweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class EmpresaDAO {
    
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
            @Qualifier("dbPswd") String dbPswd) { 
        dbFullURL = "jdbc:mysql://" + dbURL + "/" + dbName; 
        this.dbUser = dbUser; 
        this.dbPswd = dbPswd; 
    }
    
    public EmpresaDTO cargarEmpresa(int codigo){
        EmpresaDTO empresa = new EmpresaDTO();
        empresa.setCodigo(codigo);
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement(); 
            stmt.execute("SELECT * FROM empresa WHERE id = " + codigo + ""); 
            ResultSet rs = stmt.getResultSet(); 
            rs.next();
            empresa.setNombre(rs.getString("nombre"));
            empresa.setFacturacion(rs.getInt("facturacion"));
            empresa.setCantVendedores(vendedorDAO.cantidadVendedores(codigo));
            empresa.setFechaDeEntrada(rs.getString("fechaDeEntrada"));
            empresa.setSedeCentral(paisDAO.cargarPais(rs.getInt("ipPaisSede")));
            empresa.setPaises(paisDAO.cargarListaPaises(codigo));
            empresa.setAreas(areaDAO.cargarAreasCubre(codigo));
            stmt.close();
            con.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empresa;
    }
}
