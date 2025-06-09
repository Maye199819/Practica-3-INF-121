import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArchFarmacia archivo = new ArchFarmacia("farmacias.dat");

        try {
            // Crear archivo si no existe
            archivo.crearArchivo();

            boolean salir = false;
            do {
                System.out.println("1. Agregar farmacia");
                System.out.println("2. Mostrar todas farmacias");
                System.out.println("3. Mostrar medicamentos para tos de sucursal X");
                System.out.println("4. Mostrar sucursal y dirección que tienen 'Golpex'");
                System.out.println("0. Salir");
                System.out.print("Opción: ");
                int op = sc.nextInt();
                sc.nextLine();

                switch (op) {
                    case 1:
                        Farmacia f = new Farmacia();
                        f.leer();
                        archivo.adicionar(f);
                        break;
                    case 2:
                        archivo.mostrarTodas();
                        break;
                    case 3:
                        System.out.print("Ingrese número de sucursal: ");
                        int suc = sc.nextInt();
                        archivo.mostrarMedicamentosTosSucursal(suc);
                        break;
                    case 4:
                        archivo.mostrarSucursalDireccionGolpex();
                        break;
                    case 0:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } while (!salir);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        sc.close();
    }
}
