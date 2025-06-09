import json

class Medicamento:
    def __init__(self, nombre="", codMedicamento=0, tipo="", precio=0.0):
        self.nombre = nombre
        self.codMedicamento = codMedicamento
        self.tipo = tipo
        self.precio = precio

    def leer(self):
        self.nombre = input("Nombre: ")
        self.codMedicamento = int(input("Código Medicamento: "))
        self.tipo = input("Tipo (tos, resfrío, etc.): ")
        self.precio = float(input("Precio: "))

    def mostrar(self):
        print(f"Nombre: {self.nombre}, Código: {self.codMedicamento}, Tipo: {self.tipo}, Precio: {self.precio:.2f}")

    def to_dict(self):
        return {
            "nombre": self.nombre,
            "codMedicamento": self.codMedicamento,
            "tipo": self.tipo,
            "precio": self.precio
        }

    @staticmethod
    def from_dict(data):
        return Medicamento(data["nombre"], data["codMedicamento"], data["tipo"], data["precio"])


class Farmacia:
    def __init__(self, nombreFarmacia="", sucursal=0, direccion="", medicamentos=None):
        self.nombreFarmacia = nombreFarmacia
        self.sucursal = sucursal
        self.direccion = direccion
        self.medicamentos = medicamentos if medicamentos is not None else []

    def leer(self):
        self.nombreFarmacia = input("Nombre Farmacia: ")
        self.sucursal = int(input("Número de sucursal: "))
        self.direccion = input("Dirección: ")
        n = int(input("Número de medicamentos: "))
        self.medicamentos = []
        for i in range(n):
            print(f"Medicamento {i+1}:")
            m = Medicamento()
            m.leer()
            self.medicamentos.append(m)

    def mostrar(self):
        print(f"Farmacia: {self.nombreFarmacia}, Sucursal: {self.sucursal}, Dirección: {self.direccion}, Nº Medicamentos: {len(self.medicamentos)}")
        for m in self.medicamentos:
            m.mostrar()

    def mostrar_medicamentos_tipo(self, tipo_buscado):
        print(f"Medicamentos tipo '{tipo_buscado}' en la farmacia {self.nombreFarmacia} (Sucursal {self.sucursal}):")
        for m in self.medicamentos:
            if m.tipo.lower() == tipo_buscado.lower():
                m.mostrar()

    def tiene_medicamento(self, nombre_medicamento):
        return any(m.nombre.lower() == nombre_medicamento.lower() for m in self.medicamentos)

    def to_dict(self):
        return {
            "nombreFarmacia": self.nombreFarmacia,
            "sucursal": self.sucursal,
            "direccion": self.direccion,
            "medicamentos": [m.to_dict() for m in self.medicamentos]
        }

    @staticmethod
    def from_dict(data):
        medicamentos = [Medicamento.from_dict(m) for m in data.get("medicamentos", [])]
        return Farmacia(data["nombreFarmacia"], data["sucursal"], data["direccion"], medicamentos)


class ArchFarmacia:
    def __init__(self, nombre_archivo):
        self.nombre_archivo = nombre_archivo

    def crear_archivo(self):
        with open(self.nombre_archivo, "w", encoding="utf-8") as f:
            json.dump([], f)  # archivo vacío con lista vacía

    def listar(self):
        try:
            with open(self.nombre_archivo, "r", encoding="utf-8") as f:
                data = json.load(f)
                return [Farmacia.from_dict(far) for far in data]
        except (FileNotFoundError, json.JSONDecodeError):
            return []

    def guardar_todas(self, lista_farmacias):
        with open(self.nombre_archivo, "w", encoding="utf-8") as f:
            json.dump([f.to_dict() for f in lista_farmacias], f, indent=2, ensure_ascii=False)

    def adicionar(self, farmacia):
        lista = self.listar()
        lista.append(farmacia)
        self.guardar_todas(lista)

    def mostrar_todas(self):
        lista = self.listar()
        for f in lista:
            f.mostrar()
            print("-------------------------")

    def mostrar_medicamentos_tos_sucursal(self, sucursal_x):
        lista = self.listar()
        for f in lista:
            if f.sucursal == sucursal_x:
                f.mostrar_medicamentos_tipo("tos")

    def mostrar_sucursal_direccion_golpex(self):
        lista = self.listar()
        encontrado = False
        for f in lista:
            if f.tiene_medicamento("Golpex"):
                print(f"Sucursal: {f.sucursal}, Dirección: {f.direccion}")
                encontrado = True
        if not encontrado:
            print("No se encontró medicamento 'Golpex' en ninguna sucursal.")


def main():
    archivo = ArchFarmacia("farmacias.dat")

    # Crear archivo vacío si no existe
    archivo.crear_archivo()

    while True:
        print("\n--- Menú ---")
        print("1. Agregar farmacia")
        print("2. Mostrar todas farmacias")
        print("3. Mostrar medicamentos para tos de sucursal X")
        print("4. Mostrar sucursal y dirección que tienen 'Golpex'")
        print("0. Salir")

        op = input("Opción: ")
        if op == "1":
            f = Farmacia()
            f.leer()
            archivo.adicionar(f)
        elif op == "2":
            archivo.mostrar_todas()
        elif op == "3":
            try:
                suc = int(input("Ingrese número de sucursal: "))
                archivo.mostrar_medicamentos_tos_sucursal(suc)
            except ValueError:
                print("Número inválido.")
        elif op == "4":
            archivo.mostrar_sucursal_direccion_golpex()
        elif op == "0":
            print("Saliendo...")
            break
        else:
            print("Opción inválida.")


if __name__ == "__main__":
    main()
