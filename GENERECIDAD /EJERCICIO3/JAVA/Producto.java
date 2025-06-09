public class Producto {
    private String nombre;

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Producto) {
            return this.nombre.equals(((Producto) obj).nombre);
        }
        return false;
    }
}
