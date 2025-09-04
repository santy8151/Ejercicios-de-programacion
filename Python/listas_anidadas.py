# Trabajar con listas anidadas

datos = [1, [2, 3], [4, [5, 6]], 7]

def sumar(lista):
    total = 0
    for x in lista:
        if type(x) == list:
            total += sumar(x)
        else:
            total += x
    return total

def mostrar(lista, nivel=0):
    for x in lista:
        if type(x) == list:
            mostrar(x, nivel + 1)
        else:
            print("  " * nivel + str(x))

print("Lista anidada:")
mostrar(datos)
print("Suma de los elementos:", sumar(datos))
