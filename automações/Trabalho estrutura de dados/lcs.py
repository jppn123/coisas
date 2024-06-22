from random import choice

def genDna(size: int):
    dnaTypes = ['A', 'T', 'G', 'C']
    dna = ''
    for _ in range(size):
        dna += choice(dnaTypes)
        
    return dna


class Node:
    def __init__(self, data, next = None):
        self.data = data
        self.next = next

class Stack:
    def __init__(self):
        self.head = None

    def len(self):
        curr = self.head
        value = 0
        while curr:
            value+=1
            curr = curr.next
        return value

    def printList(self):
        node_aux = self.head
        while node_aux != None:
            print(node_aux.data)
            node_aux = node_aux.next

    def push(self, data):
        node = Node(data)
        node.next = self.head
        self.head = node


    def pop(self):
        if self.len() == 0:
            return "list without data error"
        if self.len() == 1:
            data = self.head.data
            self.head = None
            return data
        else:
            data = self.head.data
            self.head = self.head.next
            return data

# class Stack:
#     def __init__(self):
#         self.lista = []
    
#     def len(self):
#         return len(self.lista)
    
#     def pop(self):
#         return self.lista.pop()
    
#     def push(self, data):
#         self.lista.append(data)

def lcs(dna1, dna2):
    m = len(dna1)
    n = len(dna2)
    stack = Stack()
    stack.push((m, n, ""))
    word = ""
    while stack.len() > 0:
        m, n, aux = stack.pop()
        if len(aux) > len(word):
            word = aux
        if m > 0 and n > 0:
            if dna1[m-1] == dna2[n-1]:
                stack.push((m-1, n-1, dna1[m-1] + aux))
            else:
                stack.push((m, n-1, aux))
                stack.push((m-1, n, aux))
   
    return word

dna1 = genDna(4)
dna2 = genDna(4)
print(f'\nDna1: {dna1}\nDna2: {dna2}\n')
print(f'A maior subsequência é: {lcs(dna1, dna2)}\n')
