import java.io.*;
import java.util.*;

public class FileManager {

    private static final String FILE_NAME = "veterinaria.dat";

    // Guardar los datos (clientes, mascotas, turnos) en el archivo binario
    public static void guardarDatos(List<Cliente> clientes, List<Mascota> mascotas, List<Turno> turnos) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(clientes);
            out.writeObject(mascotas);
            out.writeObject(turnos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargar los datos desde el archivo binario
    public static void cargarDatos(List<Cliente> clientes, List<Mascota> mascotas, List<Turno> turnos) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            // Leer las listas de objetos serializados
            clientes.clear();
            mascotas.clear();
            turnos.clear();
            clientes.addAll((List<Cliente>) in.readObject());
            mascotas.addAll((List<Mascota>) in.readObject());
            turnos.addAll((List<Turno>) in.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
