#utilizando a classe node da disciplina de estrutura de dados onde nela possui 2 métodos para setar 
#os nós da esquerda/direita
class Node:
    def __init__(self,data):
        self.data=data
        self.left = None
        self.right = None
        self.father = None
        self.isLeft = False

    def setLeft(self, data):
        self.left = Node(data)
        self.isLeft = True

    def setRight(self, data):
        self.right = Node(data)
        self.isLeft = False

#utilizando uma pilha tambem da disciplina de estrutura de dados e modificando apenas seu nome
#nela,fazemos o pop retirando seu último elemento e já comparando com o valor, caso não seja
#ela continua por meio de recursão até que o valor seja encontrado
def busca_em_largura(stack, target):
    if len(stack) == 0:
        return False

    current_node = stack.pop(0)
    print(current_node.data, end=' -> ')

    if current_node.data == target:
        return True

    if current_node.left:
        stack.append(current_node.left)
    if current_node.right:
        stack.append(current_node.right)

    return busca_em_largura(stack, target)

#utilizando uma implementação de busca em árvore da disciplina de estrutura de dados temos
#a função verifica cada ponto da árvore se ele possui filho esquerdo e direito, caso possua
#ele vai seguindo até encontrar o valor passado como argumento, utilizando recursão
def busca_em_profundidade(root, target):
    if root == None:
        return False
    
    if root.data == target:
        print(root.data, end=" -> ")
        return True

    print(root.data, end=" -> ")
    if busca_em_profundidade(root.left, target) or busca_em_profundidade(root.right, target):
        return True

#aqui é apenas setando os valores da árvore e chamando as funções
root = Node(1)
root.setLeft(2)
root.setRight(3)
root.left.setLeft(4)
root.left.setRight(5)
root.right.setLeft(6)
root.right.setRight(7)
root.left.left.setLeft(8)
root.left.left.setRight(9)
root.left.right.setLeft(10)
root.left.right.setRight(11)
root.right.left.setLeft(12)
root.right.left.setRight(13)
root.right.right.setLeft(14)
root.right.right.setRight(15)


print("Busca em largura")
busca_em_profundidade(root, 11)
print()
print("Busca em profundidade")
busca_em_largura([root], 11)

'''
saída:
Busca em largura
1 -> 2 -> 4 -> 8 -> 9 -> 5 -> 10 -> 11
Busca em profundidade
1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11 
'''
