class ListNode:
    def __init__(self, value=0, next=None):
        self.value = value
        self.next = next

def remove_numeros_pares(lista):
    # Lidar com o caso de uma lista vazia
    if lista == None:
        return None

    # Lidar com o caso em que o primeiro nó é par
    while  lista.value % 2 == 0:
        lista = lista.next

    listaAux = lista

    # Percorrer a lista e remover nós com números pares
    while listaAux.next:
        if listaAux.next.value % 2 == 0:
            listaAux.next = listaAux.next.next
        else:
            listaAux = listaAux.next

    return lista

# Função auxiliar para imprimir a lista encadeada
def imprimir_lista(lista):
    atual = lista
    while atual:
        print(atual.value, end=" -> ")
        atual = atual.next
    print("None")

def somaImpar(lista):
    soma = 0
    
    while lista:
        if lista.value % 2 != 0:
            soma += lista.value
        lista = lista.next
    return soma

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def append(self, data):
        new_node = Node(data)
        if not self.head:
            self.head = new_node
            return
        current = self.head
        while current.next:
            current = current.next
        current.next = new_node

def interleave_lists(list1, list2):
    result = LinkedList()
    current1 = list1.head
    current2 = list2.head

    while current1 or current2:
        if current1:
            result.append(current1.data)
            current1 = current1.next
        if current2:
            result.append(current2.data)
            current2 = current2.next

    return result

def display_list(lst):
    current = lst.head
    while current:
        print(current.data, end="->" if current.next else "->None")
        current = current.next
    print()

# Exemplo de uso
lista = ListNode(1, ListNode(2, ListNode(6, ListNode(13, ListNode(34)))))
lista2 = LinkedList()
lista2.append(1)
lista2.append(3)
lista2.append(5)
lista1=LinkedList()
lista1.append(4)
lista1.append(66)
lista1.append(102)
# lista = ListNode(1)
print("Lista original:")
imprimir_lista(lista)
result = interleave_lists(lista1, lista2)
display_list(result)
lista_resultante = remove_numeros_pares(lista)
print("Lista após remover os números pares:")
imprimir_lista(lista_resultante)

print(somaImpar(lista))
