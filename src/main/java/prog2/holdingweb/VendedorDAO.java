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
public class VendedorDAO {
    
    private final String dbFullURL; 
    private final String dbUser; 
    private final String dbPswd;
    @Autowired
    private EmpresaDAO empresaDAO;
    
    @Autowired 
    public VendedorDAO( 
            @Qualifier("dbName") String dbName, 
            @Qualifier("dbURL")  String dbURL, 
            @Qualifier("dbUser") String dbUser, 
            @Qualifier("dbPswd") String dbPswd) { 
        dbFullURL = "jdbc:mysql://" + dbURL + "/" + dbName; 
        this.dbUser = dbUser; 
        this.dbPswd = dbPswd; 
    }
    
    public VendedorDTO cargarVendedor(int codigo){
        VendedorDTO vendedor = new VendedorDTO();
        vendedor.setCodigo(codigo);
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement(); 
            stmt.execute("SELECT * FROM vendedor WHERE id = " + codigo + ""); 
            ResultSet rs = stmt.getResultSet(); 
            rs.next();
            vendedor.setNombre(rs.getString("nombre"));
            vendedor.setFechaEntrada(rs.getString("fechaDeEntrada"));
            vendedor.setDireccion(rs.getString("direccion"));
            vendedor.setEmpresa(empresaDAO.cargarEmpresa(rs.getInt("idEmpresa")));
            vendedor.setLider(cargarVendedor(rs.getInt("idLider")));
            vendedor.setReclutas(listaReclutas(codigo));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendedor;
    }
    
    private ArrayList<VendedorDTO> listaReclutas(int codigo){
       ArrayList<VendedorDTO> reclutas = new ArrayList<>();
       try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement(); 
            stmt.execute("SELECT id FROM vendedor WHERE idLider = " + codigo + ""); 
            ResultSet rs = stmt.getResultSet(); 
            while(rs.next()){
                reclutas.add(cargarVendedor(rs.getInt("id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reclutas;
   }
    
   
    public int cantidadVendedores(int codigoEmpresa){
        int cantidadVendedores = 0;
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement(); 
            stmt.execute("SELECT COUNT(vendedor.idEmpresa) AS cantVendedores "
                    + "FROM vendedor "
                    + "WHERE vendedor.idEmpresa = " +codigoEmpresa+ ";"); 
            ResultSet rs = stmt.getResultSet(); 
            rs.next();
            cantidadVendedores = rs.getInt("cantVendedores");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cantidadVendedores;
    }
    
}
