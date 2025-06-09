import pickle
import os

class Cliente:
    def __init__(self, id, nombre, telefono):
        self.id = id
        self.nombre = nombre
        self.telefono = telefono

    def __str__(self):
        return f"Cliente [id={self.id}, nombre={self.nombre}, telefono={self.telefono}]"

class ArchivoCliente:
    def __init__(self, nombre_archivo):
        self.nombre_archivo = nombre_archivo
        self.crear_archivo()

    def crear_archivo(self):
        if not os.path.exists(self.nombre_archivo):
            with open(self.nombre_archivo, 'wb') as f:
                pickle.dump([], f)

    def leer_clientes(self):
        try:
            with open(self.nombre_archivo, 'rb') as f:
                return pickle.load(f)
        except:
            return []

    def escribir_clientes(self, lista):
        with open(self.nombre_archivo, 'wb') as f:
            pickle.dump(lista, f)

    def guarda_cliente(self, cliente):
        clientes = self.leer_clientes()
        clientes.append(cliente)
        self.escribir_clientes(clientes)

    def buscar_cliente(self, id_cliente):
        for cliente in self.leer_clientes():
            if cliente.id == id_cliente:
                return cliente
        return None

    def buscar_celular_cliente(self, id_cliente):
        cliente = self.buscar_cliente(id_cliente)
        if cliente:
            return f"{cliente} - Celular: {cliente.telefono}"
        return "Cliente no encontrado"

# ------------------ PRUEBA ------------------

archivo = ArchivoCliente("clientes.dat")

c1 = Cliente(1, "Aroha", 789456)
c2 = Cliente(2, "Jinwoo", 987321)
c3 = Cliente(3, "Moonbin", 321654)

archivo.guarda_cliente(c1)
archivo.guarda_cliente(c2)
archivo.guarda_cliente(c3)

print("Buscar Cliente 2:")
print(archivo.buscar_cliente(2))

print("Buscar celular Cliente 3:")
print(archivo.buscar_celular_cliente(3))
