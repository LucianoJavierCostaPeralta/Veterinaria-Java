import java.util.Scanner;

public class GestionMascotas {

    public static void gestionarMascotas(VeterinariaManager manager, Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Mascotas ---");
            System.out.println("1. Agregar Mascota");
            System.out.println("2. Buscar Mascota");
            System.out.println("3. Actualizar Mascota");
            System.out.println("4. Eliminar Mascota");
            System.out.println("5. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre de la mascota: ");
                    String nombreMascota = scanner.nextLine();
                    System.out.print("Ingrese tipo de la mascota: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Ingrese raza de la mascota: ");
                    String raza = scanner.nextLine();
                    System.out.print("Ingrese edad de la mascota: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese nombre del dueño (cliente): ");
                    String nombreCliente = scanner.nextLine();
                    Cliente cliente = manager.buscar(nombreCliente);
                    if (cliente != null) {
                        Mascota mascota = new Mascota(nombreMascota, edad, raza, tipo, cliente);
                        manager.agregarMascota(mascota);
                        System.out.println("Mascota agregada con éxito.");
                    } else {
                        System.out.println("Cliente no encontrado. No se pudo agregar la mascota.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la mascota a buscar: ");
                    nombreMascota = scanner.nextLine();
                    Mascota mascota = manager.buscarMascota(nombreMascota);
                    if (mascota != null) {
                        System.out.println("Mascota encontrada: " + mascota); // Usando toString()
                    } else {
                        System.out.println("Mascota no encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la mascota a actualizar: ");
                    nombreMascota = scanner.nextLine();
                    Mascota mascotaActualizar = manager.buscarMascota(nombreMascota);
                    if (mascotaActualizar != null) {
                        System.out.print("Ingrese nueva raza: ");
                        String nuevaRaza = scanner.nextLine();
                        System.out.print("Ingrese nueva edad: ");
                        int nuevaEdad = scanner.nextInt();
                        scanner.nextLine();
                        mascotaActualizar.setRaza(nuevaRaza);
                        mascotaActualizar.setEdad(nuevaEdad);
                        System.out.println("Mascota actualizada con éxito.");
                    } else {
                        System.out.println("Mascota no encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre de la mascota a eliminar: ");
                    nombreMascota = scanner.nextLine();
                    manager.eliminarMascota(nombreMascota);
                    System.out.println("Mascota eliminada si existía.");
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
}
