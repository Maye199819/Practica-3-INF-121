public class Main {
    public static void main(String[] args) {
        // Pila de enteros
        Pila<Integer> pilaEnteros = new Pila<>();
        pilaEnteros.apilar(10);
        pilaEnteros.apilar(20);
        pilaEnteros.mostrar();
        System.out.println("Desapilado: " + pilaEnteros.desapilar());
        pilaEnteros.mostrar();

        // Pila de cadenas
        Pila<String> pilaCadenas = new Pila<>();
        pilaCadenas.apilar("Hola");
        pilaCadenas.apilar("Mundo");
        pilaCadenas.mostrar();
        System.out.println("Desapilado: " + pilaCadenas.desapilar());
        pilaCadenas.mostrar();
    }
}
