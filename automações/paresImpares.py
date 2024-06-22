def organizar_pares_impares(arr):
    if not arr:
        return []
    
    primeiro = arr[0]
    resto = arr[1:]
    
    pares = [x for x in resto if x % 2 == 0]
    impares = [x for x in resto if x % 2 != 0]
    if primeiro %2 == 0:
        return [primeiro] + organizar_pares_impares(pares) + organizar_pares_impares(impares)
    return organizar_pares_impares(pares) + organizar_pares_impares(impares) + [primeiro] 

# Exemplo de uso
sequencia = [2, 5, 2, 9, 1, 6, 8]
sequencia_organizada = organizar_pares_impares(sequencia)
print(sequencia_organizada)