class Caja<T> {
    private T contenido;

    public void guardar(T valor) {
        this.contenido = valor;
    }

    public T obtener() {
        return contenido;
    }
}

public class Main {
    public static void main(String[] args) {
        // Caja para un String
        Caja<String> cajaDeTexto = new Caja<>();
        cajaDeTexto.guardar("Astro Aroha");

        // Caja para un Integer
        Caja<Integer> cajaDeNumero = new Caja<>();
        cajaDeNumero.guardar(123);

        // Mostrar contenido
        System.out.println("Contenido de cajaDeTexto: " + cajaDeTexto.obtener());
        System.out.println("Contenido de cajaDeNumero: " + cajaDeNumero.obtener());
    }
}
