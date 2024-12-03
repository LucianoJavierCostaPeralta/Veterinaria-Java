import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VeterinariaManager manager = new VeterinariaManager();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Mascotas");
            System.out.println("3. Gestionar Turnos");
            System.out.println("4. Listar Clientes con Mascotas y Turnos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    GestionClientes.gestionarClientes(manager, scanner);
                    break;
                case 2:
                    GestionMascotas.gestionarMascotas(manager, scanner);
                    break;
                case 3:
                    GestionTurnos.gestionarTurnos(manager, scanner);
                    break;
                case 4:
                    manager.listarClientesConMascotasYTurnos();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
