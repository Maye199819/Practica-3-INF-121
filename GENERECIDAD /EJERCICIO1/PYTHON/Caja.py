from typing import Generic, TypeVar

T = TypeVar('T')

class Caja(Generic[T]):
    def __init__(self):
        self.contenido: T = None

    def guardar(self, valor: T):
        self.contenido = valor

    def obtener(self) -> T:
        return self.contenido

# Caja para un String
caja_de_texto = Caja[str]()
caja_de_texto.guardar("Astro Aroha")

# Caja para un Integer
caja_de_numero = Caja[int]()
caja_de_numero.guardar(123)

# Mostrar contenido
print("Contenido de caja_de_texto:", caja_de_texto.obtener())
print("Contenido de caja_de_numero:", caja_de_numero.obtener())
