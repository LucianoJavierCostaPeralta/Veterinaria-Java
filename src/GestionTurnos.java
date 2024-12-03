import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GestionTurnos {

    public static void gestionarTurnos(VeterinariaManager manager, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Turnos ---");
            System.out.println("1. Agregar Turno");
            System.out.println("2. Buscar Turno");
            System.out.println("3. Actualizar Turno");
            System.out.println("4. Eliminar Turno");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre de la mascota para el turno: ");
                    String nombreMascota = scanner.nextLine();
                    Mascota mascota = manager.buscarMascota(nombreMascota);
                    if (mascota != null) {
                        System.out.print("Ingrese motivo del turno: ");
                        String motivo = scanner.nextLine();
                        System.out.print("Ingrese fecha del turno (dd/MM/yyyy): ");
                        String fechaStr = scanner.nextLine();
                        try {
                            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
                            Turno turno = new Turno(fecha, motivo, mascota);
                            manager.agregarTurno(turno);
                            System.out.println("Turno agregado con éxito.");
                        } catch (ParseException e) {
                            System.out.println("Formato de fecha incorrecto.");
                        }
                    } else {
                        System.out.println("Mascota no encontrada. No se pudo agendar el turno.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el motivo del turno a buscar: ");
                    String motivo = scanner.nextLine();
                    Turno turno = manager.buscarTurno(motivo);
                    if (turno != null) {
                        System.out.println("Turno encontrado: " + turno.getMotivo() + " para "
                                + turno.getMascota().getNombre() + " en " + turno.getFecha());
                    } else {
                        System.out.println("Turno no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el motivo del turno a actualizar: ");
                    String motivoActualizar = scanner.nextLine();
                    Turno turnoActualizar = manager.buscarTurno(motivoActualizar);
                    if (turnoActualizar != null) {
                        System.out.print("Ingrese nueva fecha (dd/MM/yyyy): ");
                        String nuevaFechaStr = scanner.nextLine();
                        try {
                            Date nuevaFecha = new SimpleDateFormat("dd/MM/yyyy").parse(nuevaFechaStr);
                            turnoActualizar.setFecha(nuevaFecha);
                            System.out.println("Turno actualizado con éxito.");
                        } catch (ParseException e) {
                            System.out.println("Formato de fecha incorrecto.");
                        }
                    } else {
                        System.out.println("Turno no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el motivo del turno a eliminar: ");
                    motivo = scanner.nextLine();
                    manager.eliminarTurno(motivo);
                    System.out.println("Turno eliminado si existía.");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
}
