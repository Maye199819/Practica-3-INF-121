from typing import Generic, TypeVar, List

T = TypeVar('T')

class Pila(Generic[T]):
    def __init__(self):
        self.elementos: List[T] = []

    def apilar(self, elemento: T):
        self.elementos.append(elemento)

    def desapilar(self) -> T:
        if self.elementos:
            return self.elementos.pop()
        return None

    def mostrar(self):
        print("Contenido de la pila:")
        for elem in reversed(self.elementos):
            print(elem)

# Pruebas
pila_enteros = Pila[int]()
pila_enteros.apilar(10)
pila_enteros.apilar(20)
pila_enteros.mostrar()
print("Desapilado:", pila_enteros.desapilar())
pila_enteros.mostrar()

pila_cadenas = Pila[str]()
pila_cadenas.apilar("Astro")
pila_cadenas.apilar("Aroha")
pila_cadenas.mostrar()
print("Desapilado:", pila_cadenas.desapilar())
pila_cadenas.mostrar()
