import java.io.Serializable;
import java.util.Scanner;

public class Farmacia implements Serializable {
    private String nombreFarmacia;
    private int sucursal;
    private String direccion;
    private int nroMedicamentos;
    private Medicamento[] m = new Medicamento[100];

    public Farmacia() {
        nroMedicamentos = 0;
    }

    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre Farmacia: ");
        nombreFarmacia = sc.nextLine();
        System.out.print("Número de sucursal: ");
        sucursal = sc.nextInt();
        sc.nextLine();
        System.out.print("Dirección: ");
        direccion = sc.nextLine();
        System.out.print("Número de medicamentos: ");
        nroMedicamentos = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nroMedicamentos; i++) {
            System.out.println("Medicamento " + (i + 1) + ":");
            m[i] = new Medicamento();
            m[i].leer();
        }
    }

    public void mostrar() {
        System.out.printf("Farmacia: %s, Sucursal: %d, Dirección: %s, Nº Medicamentos: %d\n",
            nombreFarmacia, sucursal, direccion, nroMedicamentos);
        for (int i = 0; i < nroMedicamentos; i++) {
            m[i].mostrar();
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void mostrarMedicamentos(String tipoBuscado) {
        System.out.printf("Medicamentos tipo '%s' en la farmacia %s (Sucursal %d):\n",
            tipoBuscado, nombreFarmacia, sucursal);
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i].getTipo().equalsIgnoreCase(tipoBuscado)) {
                m[i].mostrar();
            }
        }
    }

    public boolean buscaMedicamento(String nombreMedicamento) {
        for (int i = 0; i < nroMedicamentos; i++) {
            if (m[i].getNombre().equalsIgnoreCase(nombreMedicamento)) {
                return true;
            }
        }
        return false;
    }
}
