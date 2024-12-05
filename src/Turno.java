import java.io.Serializable;
import java.util.Date;

public class Turno implements Serializable, Comparable<Turno> {
    private Date fecha;
    private String motivo;
    private Mascota mascota;
    private static final long serialVersionUID = 1L;

    public Turno() {
    }

    public Turno(Date fecha, String motivo, Mascota mascota) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.mascota = mascota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public int compareTo(Turno otroTurno) {
        // Compara las fechas, de la más reciente a la más antigua
        return otroTurno.getFecha().compareTo(this.fecha);
    }
}
