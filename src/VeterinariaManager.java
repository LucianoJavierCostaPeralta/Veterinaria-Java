import java.util.ArrayList;
import java.util.List;

public class VeterinariaManager implements CRUDOperations<Cliente> {
    private List<Cliente> clientes;
    private List<Mascota> mascotas;
    private List<Turno> turnos;

    public VeterinariaManager() {
        this.clientes = new ArrayList<>();
        this.mascotas = new ArrayList<>();
        this.turnos = new ArrayList<>();
    }

    @Override
    public void agregar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente buscar(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Cliente cliente) {
        Cliente existente = buscar(cliente.getNombre());
        if (existente != null) {
            existente.setEmail(cliente.getEmail());
            existente.getMascotas().clear();
            existente.getMascotas().addAll(cliente.getMascotas());
        }
    }

    @Override
    public void eliminar(String nombre) {
        clientes.removeIf(cliente -> cliente.getNombre().equalsIgnoreCase(nombre));
    }

    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(clientes);
    }

    public void agregarMascota(Mascota mascota) {
        mascotas.add(mascota);
        Cliente cliente = mascota.getCliente();
        if (cliente != null) {
            cliente.agregarMascota(mascota);
        }
    }

    public Mascota buscarMascota(String nombre) {
        for (Mascota mascota : mascotas) {
            if (mascota.getNombre().equalsIgnoreCase(nombre)) {
                return mascota;
            }
        }
        return null;
    }

    public void eliminarMascota(String nombre) {
        mascotas.removeIf(mascota -> mascota.getNombre().equalsIgnoreCase(nombre));
    }

    public void agregarTurno(Turno turno) {
        turnos.add(turno);
    }

    public Turno buscarTurno(String motivo) {
        for (Turno turno : turnos) {
            if (turno.getMotivo().equalsIgnoreCase(motivo)) {
                return turno;
            }
        }
        return null;
    }

    public void eliminarTurno(String motivo) {
        turnos.removeIf(turno -> turno.getMotivo().equalsIgnoreCase(motivo));
    }

    public List<Turno> listarTurnosPorMascota(String nombreMascota) {
        List<Turno> turnosMascota = new ArrayList<>();
        for (Turno turno : turnos) {
            if (turno.getMascota().getNombre().equalsIgnoreCase(nombreMascota)) {
                turnosMascota.add(turno);
            }
        }
        return turnosMascota;
    }

    public void listarClientesConMascotasYTurnos() {
        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getNombre());
            for (Mascota mascota : cliente.getMascotas()) {
                System.out.println("  - Mascota: " + mascota.describir());
                for (Turno turno : listarTurnosPorMascota(mascota.getNombre())) {
                    System.out.println("    - Turno: " + turno.getMotivo() + " en " + turno.getFecha());
                }
            }
        }
    }
}
