import java.io.Serializable;
import java.util.Scanner;

public class Medicamento implements Serializable {
    private String nombre;
    private int codMedicamento;
    private String tipo;
    private double precio;

    public Medicamento() { }

    public void leer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Codigo Medicamento: ");
        codMedicamento = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        System.out.print("Tipo (tos, resfrio, etc.): ");
        tipo = sc.nextLine();
        System.out.print("Precio: ");
        precio = sc.nextDouble();
    }

    public void mostrar() {
        System.out.printf("Nombre: %s, Código: %d, Tipo: %s, Precio: %.2f\n",
            nombre, codMedicamento, tipo, precio);
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}
