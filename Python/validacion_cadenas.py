# Validar una cadena de texto

texto = input("Escriba una cadena: ")

if len(texto) == 0:
    print("La cadena está vacía")
elif len(texto) < 5:
    print("La cadena es muy corta (mínimo 5)")
elif not texto.isalnum():
    print("La cadena tiene símbolos raros")
else:
    print("La cadena es válida")
