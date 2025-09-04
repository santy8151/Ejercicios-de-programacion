# Calcular números primos hasta un número dado

def es_primo(n):
    if n < 2:
        return False
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

limite = int(input("Ingrese un número: "))
primos = []

for i in range(2, limite + 1):
    if es_primo(i):
        primos.append(i)

print("Primos hasta", limite, ":", primos)
