import java.util.List;

public interface CRUDOperations<T> {
    void agregar(T obj);

    T buscar(String criterio);

    void actualizar(T obj);

    void eliminar(String criterio);

    List<T> listar();
}
