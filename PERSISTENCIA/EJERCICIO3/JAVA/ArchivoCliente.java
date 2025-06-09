import java.io.*;
import java.util.ArrayList;

public class ArchivoCliente {
    private String nomA;

    public ArchivoCliente(String nomA) {
        this.nomA = nomA;
        crearArchivo();
    }

    private void crearArchivo() {
        File archivo = new File(nomA);
        if (!archivo.exists()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
                oos.writeObject(new ArrayList<Cliente>());
            } catch (IOException e) {
                System.out.println("Error al crear archivo: " + e.getMessage());
            }
        }
    }

    private ArrayList<Cliente> leerClientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomA))) {
            return (ArrayList<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private void escribirClientes(ArrayList<Cliente> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomA))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Error al escribir archivo: " + e.getMessage());
        }
    }

    public void guardaCliente(Cliente c) {
        ArrayList<Cliente> lista = leerClientes();
        lista.add(c);
        escribirClientes(lista);
    }

    public Cliente buscarCliente(int c) {
        ArrayList<Cliente> lista = leerClientes();
        for (Cliente cli : lista) {
            if (cli.getId() == c) {
                return cli;
            }
        }
        return null;
    }

    public String buscarCelularCliente(int c) {
        Cliente cli = buscarCliente(c);
        if (cli != null) {
            return cli.toString() + " - Celular: " + cli.getTelefono();
        }
        return "Cliente no encontrado";
    }
}
