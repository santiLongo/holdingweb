package prog2.holdingweb;

import java.io.Serializable;
import java.util.Objects;

public class AsesoraPK implements Serializable {
    private Long asesor;
    private Long empresa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AsesoraPK)) return false;
        AsesoraPK that = (AsesoraPK) o;
        return asesor.equals(that.asesor) && empresa.equals(that.empresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asesor, empresa);
    }
}