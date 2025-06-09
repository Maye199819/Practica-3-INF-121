public class Main {
    public static void main(String[] args) {
        ArchivoCliente archivo = new ArchivoCliente("clientes.dat");

        Cliente c1 = new Cliente(1, "Aroha", 789456);
        Cliente c2 = new Cliente(2, "Jinwoo", 987321);
        Cliente c3 = new Cliente(3, "Moonbin", 321654);

        archivo.guardaCliente(c1);
        archivo.guardaCliente(c2);
        archivo.guardaCliente(c3);

        System.out.println("Buscar Cliente 2:");
        System.out.println(archivo.buscarCliente(2));

        System.out.println("Buscar celular Cliente 3:");
        System.out.println(archivo.buscarCelularCliente(3));
    }
}

