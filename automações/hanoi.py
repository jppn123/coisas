def hanoi(n, origem, destino, auxiliar):
    if n == 1:
        print(f'Mova o disco 1 de {origem} para {destino}')
        return
    hanoi(n - 1, origem, auxiliar, destino)
    print(f'Mova o disco {n} de {origem} para {destino}')
    hanoi(n - 1, auxiliar, destino, origem)

# Exemplo de uso
n = 3  # Número de discos
hanoi(n, 'A', 'C', 'B')