import java.util.ArrayList;
import java.util.List;

public class Catalogo<T> {
    private List<T> elementos;

    public Catalogo() {
        elementos = new ArrayList<>();
    }

    public void agregar(T elemento) {
        elementos.add(elemento);
    }

    public boolean buscar(T elemento) {
        return elementos.contains(elemento);
    }

    public void mostrarTodo() {
        for (T e : elementos) {
            System.out.println(e);
        }
    }
}
