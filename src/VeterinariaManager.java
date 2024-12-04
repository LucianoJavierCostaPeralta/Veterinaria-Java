import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VeterinariaManager implements CRUDOperations<Cliente> {
    private List<Cliente> clientes;
    private List<Mascota> mascotas;
    private List<Turno> turnos;

    public VeterinariaManager() {
        this.clientes = new ArrayList<>();
        this.mascotas = new ArrayList<>();
        this.turnos = new ArrayList<>();

        FileManager.cargarDatos(clientes, mascotas, turnos);
    }

    // Métodos de CRUD para clientes
    @Override
    public void agregar(Cliente cliente) {
        clientes.add(cliente);
        FileManager.guardarDatos(clientes, mascotas, turnos);
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
            if (!existente.getNombre().equals(cliente.getNombre())) {
                existente.setNombre(cliente.getNombre());
            }
            if (!existente.getEmail().equals(cliente.getEmail())) {
                existente.setEmail(cliente.getEmail());
            }
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

    // Método para manejar la actualización de cliente con interacción
    public void actualizarClienteConInteraccion(Scanner scanner, String nombre) {
        Cliente clienteActualizar = buscar(nombre);
        if (clienteActualizar != null) {
            // Mostrar la información actual del cliente
            System.out.println("Cliente actual: ");
            System.out.println("Nombre: " + clienteActualizar.getNombre());
            System.out.println("Email: " + clienteActualizar.getEmail());

            // Preguntar si se desea actualizar todos los atributos o solo uno
            System.out.println("¿Desea actualizar?");
            System.out.println("1. Solo el nombre");
            System.out.println("2. Solo el email");
            System.out.println("3. Actualizar ambos");
            System.out.println("4. No actualizar");
            int opcionActualizacion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcionActualizacion) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    clienteActualizar.setNombre(nuevoNombre);
                    System.out.println("Nombre actualizado con éxito.");
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo email: ");
                    String nuevoEmail = scanner.nextLine();
                    clienteActualizar.setEmail(nuevoEmail);
                    System.out.println("Email actualizado con éxito.");
                    break;
                case 3:
                    System.out.print("Ingrese el nuevo nombre: ");
                    nuevoNombre = scanner.nextLine();
                    clienteActualizar.setNombre(nuevoNombre);

                    System.out.print("Ingrese el nuevo email: ");
                    nuevoEmail = scanner.nextLine();
                    clienteActualizar.setEmail(nuevoEmail);
                    System.out.println("Nombre y email actualizados con éxito.");
                    break;
                case 4:
                    System.out.println("No se realizó ninguna actualización.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    // Métodos para gestionar Mascotas
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

    public List<Mascota> listarMascotas() {
        return new ArrayList<>(mascotas);
    }

    // Métodos para gestionar Turnos
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

    // Método para listar todos los clientes con sus mascotas y turnos
    public void listarClientesConMascotasYTurnos() {
        for (Cliente cliente : clientes) {
            System.out.println("Cliente: " + cliente.getNombre());
            for (Mascota mascota : cliente.getMascotas()) {
                System.out.println(mascota.toString());
                for (Turno turno : listarTurnosPorMascota(mascota.getNombre())) {
                    System.out.println("    - Turno: " + turno.getMotivo() + " en " + turno.getFecha());
                }
            }
        }
    }
}
