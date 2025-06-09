from typing import Generic, TypeVar, List

T = TypeVar('T')

class Catalogo(Generic[T]):
    def __init__(self):
        self.elementos: List[T] = []

    def agregar(self, elemento: T):
        self.elementos.append(elemento)

    def buscar(self, elemento: T) -> bool:
        return elemento in self.elementos

    def mostrar_todo(self):
        for e in self.elementos:
            print(e)

class Libro:
    def __init__(self, titulo: str):
        self.titulo = titulo

    def __str__(self):
        return f"Libro: {self.titulo}"

    def __eq__(self, other):
        return isinstance(other, Libro) and self.titulo == other.titulo

class Producto:
    def __init__(self, nombre: str):
        self.nombre = nombre

    def __str__(self):
        return f"Producto: {self.nombre}"

    def __eq__(self, other):
        return isinstance(other, Producto) and self.nombre == other.nombre

# Prueba
catalogo_libros = Catalogo[Libro]()
catalogo_libros.agregar(Libro("Cien años de soledad"))
catalogo_libros.agregar(Libro("El Principito"))
catalogo_libros.mostrar_todo()
print("¿Está 'El Principito'?", catalogo_libros.buscar(Libro("El Principito")))

catalogo_productos = Catalogo[Producto]()
catalogo_productos.agregar(Producto("Laptop"))
catalogo_productos.agregar(Producto("Celular"))
catalogo_productos.mostrar_todo()
print("¿Está 'Tablet'?", catalogo_productos.buscar(Producto("Tablet")))
