public class Main {
    public static void main(String[] args) {
        // Catálogo de Libros
        Catalogo<Libro> catalogoLibros = new Catalogo<>();
        catalogoLibros.agregar(new Libro("Cien años de soledad"));
        catalogoLibros.agregar(new Libro("El Principito"));
        catalogoLibros.mostrarTodo();

        System.out.println("¿Está 'El Principito'? " + catalogoLibros.buscar(new Libro("El Principito")));

        // Catálogo de Productos
        Catalogo<Producto> catalogoProductos = new Catalogo<>();
        catalogoProductos.agregar(new Producto("Laptop"));
        catalogoProductos.agregar(new Producto("Celular"));
        catalogoProductos.mostrarTodo();

        System.out.println("¿Está 'Tablet'? " + catalogoProductos.buscar(new Producto("Tablet")));
    }
}
