def contaGrau(matriz):
    graus = []
    #seria apenas a soma de cada conexão aresta-vertice onde cada linha é um vértice
    for vertice in matriz:
        graus.append(sum(vertice))

    return graus
'''
matriz = [
    [0, 1, 1, 0, 1],
    [1, 0, 1, 1, 1],
    [1, 1, 0, 1, 0],
    [0, 1, 1, 0, 1],
    [1, 1, 0, 1, 0]
]'''
matriz = [
    [0, 0, 0, 1, 1, 1, 1],
    [0, 0, 0, 1, 1, 1, 1],
    [0, 0, 0, 1, 1, 1, 1],
    [1, 1, 1, 0, 0, 0, 0],
    [1, 1, 1, 0, 0, 0, 0],
    [1, 1, 1, 0, 0, 0, 0],
    [1, 1, 1, 0, 0, 0, 0]
]
print("Graus de cada vertice: ")
i = 1
for vertice in contaGrau(matriz):
    print(f"vertice {i} tem grau {vertice}")
    i += 1
