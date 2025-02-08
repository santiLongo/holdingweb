package prog2.holdingweb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class PaisDTO{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String capital;
    
    @Column(nullable = false)
    private int pbi;
    
    @Column(name = "cantHabitantes", nullable = false)
    private int cantHabitantes;
    
    public PaisDTO(String nombre, String capital, int pbi, int cantHabitantes){
        this.nombre = nombre;
        this.capital = capital;
        this.pbi = pbi;
        this.cantHabitantes = cantHabitantes;
    }
    
    protected PaisDTO(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPbi() {
        return pbi;
    }

    public void setPbi(int pbi) {
        this.pbi = pbi;
    }

    public int getCantHabitantes() {
        return cantHabitantes;
    }

    public void setCantHabitantes(int cantidadHabitantes) {
        this.cantHabitantes = cantidadHabitantes;
    }

    public Long getCodigo() {
        return id;
    }

    public void setId(Long codigo) {
        this.id = id;
    }
}
