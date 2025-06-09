import java.io.*;
import java.util.ArrayList;

public class ArchFarmacia {
    private String na;  // nombre archivo .dat

    public ArchFarmacia(String na) {
        this.na = na;
    }

    // Crear archivo vacío
    public void crearArchivo() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(na));
        oos.writeObject(new ArrayList<Farmacia>()); // lista vacía
        oos.close();
    }

    // Adicionar una Farmacia al archivo
    public void adicionar(Farmacia f) throws IOException, ClassNotFoundException {
        ArrayList<Farmacia> lista = listar();
        lista.add(f);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(na));
        oos.writeObject(lista);
        oos.close();
    }

    // Leer todas las farmacias
    @SuppressWarnings("unchecked")
    public ArrayList<Farmacia> listar() throws IOException, ClassNotFoundException {
        File file = new File(na);
        if(!file.exists()) return new ArrayList<>();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(na));
        ArrayList<Farmacia> lista = (ArrayList<Farmacia>) ois.readObject();
        ois.close();
        return lista;
    }

    // Mostrar todas farmacias y medicamentos
    public void mostrarTodas() throws IOException, ClassNotFoundException {
        ArrayList<Farmacia> lista = listar();
        for (Farmacia f : lista) {
            f.mostrar();
            System.out.println("---------------------------");
        }
    }

    // Mostrar medicamentos para tos en sucursal X
    public void mostrarMedicamentosTosSucursal(int sucursalX) throws IOException, ClassNotFoundException {
        ArrayList<Farmacia> lista = listar();
        for (Farmacia f : lista) {
            if (f.getSucursal() == sucursalX) {
                f.mostrarMedicamentos("tos");
            }
        }
    }

    // Mostrar sucursal y dirección que tienen medicamento "Golpex"
    public void mostrarSucursalDireccionGolpex() throws IOException, ClassNotFoundException {
        ArrayList<Farmacia> lista = listar();
        for (Farmacia f : lista) {
            if (f.buscaMedicamento("Golpex")) {
                System.out.printf("Sucursal: %d, Dirección: %s\n",
                    f.getSucursal(), f.getDireccion());
            }
        }
    }
}
