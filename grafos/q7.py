def bipartidoCompleto(m, n):
    if m < 2 or m > 20 or n < 2 or n > 20:
        print("m e n devem ser => 2 e <= 20")
        return
    
    matriz = []
    
    for i in range(m+n):
        linha = []
        for j in range(n+m):
            '''
            pensei no esboço do gráfico, a partir de m, sempre terá que ser 1 já que é necessário ter apenas 2 grupos
            então terá que ser 1 o número de vezes de n, ou seja, j tem que ser maior que n para contar 1. Após isso é
            só fazer o contrário para fazer a matriz do grafo bipartido.
            '''
            if i < m:
                if j >= m:
                    linha.append(1)
                else:
                    linha.append(0)
            elif i >= m:
                if j < m:
                    linha.append(1)
                else:
                    linha.append(0)
        matriz.append(linha)

    return matriz

m = 3
n = 4
matriz = bipartidoCompleto(m, n)
for linha in matriz:
    print(linha)