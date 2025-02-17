package prog2.holdingweb;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "asesora")
@IdClass(AsesoraPK.class)
public class AsesoraDTO {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idAsesor", nullable = false)
    private AsesorDTO asesor;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "idEmpresa", nullable = false)
    private EmpresaDTO empresa;

    @Column(name = "fechaDeEntrada")
    private LocalDate fechaDeEntrada;
    
    protected AsesoraDTO(){
    }
    
    public AsesoraDTO(EmpresaDTO empresa, AsesorDTO asesor) {
        this.empresa = empresa;
        this.asesor = asesor;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public LocalDate getFechaDeEntrada() {
        return fechaDeEntrada;
    }

    public void setFechaDeEntrada(LocalDate fechaEntrada) {
        this.fechaDeEntrada = fechaEntrada;
    }

    
}

