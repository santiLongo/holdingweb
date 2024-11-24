package prog2.holdingweb;

public class PaisDTO{
    
    private String nombre;
    private String capital;
    private int pbi;
    private int cantidadHabitantes;
    
    public PaisDTO(){
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
    
    
}
