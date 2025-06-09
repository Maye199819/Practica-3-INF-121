import pickle
import os

class Empleado:
    def __init__(self, nombre, edad, salario):
        self.nombre = nombre
        self.edad = edad
        self.salario = salario

    def __str__(self):
        return f"Empleado [nombre={self.nombre}, edad={self.edad}, salario={self.salario}]"

class ArchivoEmpleado:
    def __init__(self, nombre_archivo):
        self.nombre_archivo = nombre_archivo
        self.crear_archivo()

    def crear_archivo(self):
        if not os.path.exists(self.nombre_archivo):
            with open(self.nombre_archivo, 'wb') as f:
                pickle.dump([], f)

    def leer_empleados(self):
        try:
            with open(self.nombre_archivo, 'rb') as f:
                return pickle.load(f)
        except:
            return []

    def escribir_empleados(self, lista):
        with open(self.nombre_archivo, 'wb') as f:
            pickle.dump(lista, f)

    def guardar_empleado(self, empleado):
        empleados = self.leer_empleados()
        empleados.append(empleado)
        self.escribir_empleados(empleados)

    def buscar_empleado(self, nombre):
        for empleado in self.leer_empleados():
            if empleado.nombre.lower() == nombre.lower():
                return empleado
        return None

    def mayor_salario(self, sueldo):
        for empleado in self.leer_empleados():
            if empleado.salario > sueldo:
                return empleado
        return None

# ------------------ PRUEBA ------------------

archivo = ArchivoEmpleado("empleados.dat")

e1 = Empleado("Ana", 30, 3500.0)
e2 = Empleado("Luis", 40, 4200.0)
e3 = Empleado("Marta", 28, 2800.0)

archivo.guardar_empleado(e1)
archivo.guardar_empleado(e2)
archivo.guardar_empleado(e3)

print("Buscar Luis:", archivo.buscar_empleado("Luis"))
print("Mayor salario a 3000:", archivo.mayor_salario(3000))
