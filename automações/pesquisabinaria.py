def pesquisa_binaria_recursiva(arr, alvo, limite_inferior, limite_superior):
    if limite_inferior > limite_superior:
        return -1  # O elemento não foi encontrado

    meio = (limite_inferior + limite_superior) // 2

    if arr[meio] == alvo:
        return meio  # O elemento foi encontrado na posição 'meio'
    elif arr[meio] > alvo:
        return pesquisa_binaria_recursiva(arr, alvo, limite_inferior, meio - 1)  # Pesquisar na metade esquerda
    else:
        return pesquisa_binaria_recursiva(arr, alvo, meio + 1, limite_superior)  # Pesquisar na metade direita

# Exemplo de uso
sequencia = [4, 10, 12, 32, 34, 35, 43, 76]
alvo = 10
resultado = pesquisa_binaria_recursiva(sequencia, alvo, 0, len(sequencia) - 1)

if resultado != -1:
    print(f'O elemento {alvo} foi encontrado na posição {resultado}')
else:
    print(f'O elemento {alvo} não foi encontrado na sequência')