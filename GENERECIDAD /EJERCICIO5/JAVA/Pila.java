import java.util.ArrayList;
import java.util.List;

class Pila<T> {
    private List<T> elementos;

    public Pila() {
        elementos = new ArrayList<>();
    }

    // a) Método para apilar
    public void apilar(T elemento) {
        elementos.add(elemento);
    }

    // b) Método para desapilar
    public T desapilar() {
        if (!elementos.isEmpty()) {
            return elementos.remove(elementos.size() - 1);
        }
        return null;
    }

    // d) Mostrar pila
    public void mostrar() {
        System.out.println("Contenido de la pila:");
        for (int i = elementos.size() - 1; i >= 0; i--) {
            System.out.println(elementos.get(i));
        }
    }
}
