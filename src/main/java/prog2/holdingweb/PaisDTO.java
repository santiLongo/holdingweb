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
    
    @Column(nullable = false)
    private int cantidadHabitantes;
    
    public PaisDTO(String nombre, String capital, int pbi, int cantidadHabitantes){
        this.nombre = nombre;
        this.capital = capital;
        this.pbi = pbi;
        this.cantidadHabitantes = cantidadHabitantes;
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

    public int getCantidadHabitantes() {
        return cantidadHabitantes;
    }

    public void setCantidadHabitantes(int cantidadHabitantes) {
        this.cantidadHabitantes = cantidadHabitantes;
    }

    public Long getCodigo() {
        return id;
    }

    public void setId(Long codigo) {
        this.id = id;
    }
}
