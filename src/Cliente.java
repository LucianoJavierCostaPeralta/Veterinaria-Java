import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {
    private String nombre;
    private String email;
    private List<Mascota> mascotas;
    private static final long serialVersionUID = 1L;

    public Cliente() {
        this.mascotas = new ArrayList<>();
    }

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.mascotas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void agregarMascota(Mascota mascota) {
        this.mascotas.add(mascota);
    }
}
