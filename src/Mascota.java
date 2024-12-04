public class Mascota extends Animal {
    private String raza;
    private String tipo;
    private Cliente cliente;

    public Mascota() {
    }

    public Mascota(String nombre, int edad, String raza, String tipo, Cliente cliente) {
        super(nombre, edad);
        this.raza = raza;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        // Título de la tabla
        String title = "Tabla de Mascotas";

        // Formateamos la tabla
        String header = String.format("| %-15s | %-10s | %-10s | %-5s |", "Nombre", "Tipo", "Raza", "Edad");
        String separator = "+-----------------+------------+------------+-------+";
        String data = String.format("| %-15s | %-10s | %-10s | %-5d |", getNombre(), tipo, raza, getEdad());

        // Juntamos el título con la tabla
        return title + "\n\n" + separator + "\n" + header + "\n" + separator + "\n" + data + "\n" + separator;
    }

}
