public class Main {
    public static void main(String[] args) {
        ArchivoEmpleado archivo = new ArchivoEmpleado("empleados.dat");

        Empleado e1 = new Empleado("Ana", 30, 3500f);
        Empleado e2 = new Empleado("Luis", 40, 4200f);
        Empleado e3 = new Empleado("Marta", 28, 2800f);

        archivo.guardarEmpleado(e1);
        archivo.guardarEmpleado(e2);
        archivo.guardarEmpleado(e3);

        System.out.println("Buscar Luis: " + archivo.buscaEmpleado("Luis"));
        System.out.println("Mayor salario a 3000: " + archivo.mayorSalario(3000f));
    }
}
