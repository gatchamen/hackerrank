import sys

class Node(object):

    def __init__(self,data):
        self.data = data
        self.left = self.right = None

class BinaryTree(object):

    def __init__(self):
        self.root = None

    def insert(self, data):
        self.root = self._insert(self.root, data)

    def _insert(self, node, data):
        if node is None:
            node = Node(data)
        else:
            if node.data >= data:
                node.left = self._insert(node.left, data)
            else:
                node.right = self._insert(node.right, data)
        return node

    def traverse_postorder(self, node):
        if node is not None:
            self.traverse_postorder(node.left)
            self.traverse_postorder(node.right)
            if node == self.root:
                print(node.data)
            else:
                print(node.data, end=' ')

class PreorderToPostorder(object):
    def __init__(self):
        pass
    def get_input(self, inputType=1):
        if inputType == 0:
            T = int(sys.stdin.readline().strip())
            return T
        else:
            N = int(sys.stdin.readline().strip())
            arr = list(map(int,sys.stdin.readline().split()))
            return N, arr

    def change_order(self, nodeNum, nodes):
        bst = BinaryTree()
        for index in range(nodeNum):
            bst.insert(nodes[index])
        bst.traverse_postorder(bst.root)

    def solve(self):
        testcaseNum = self.get_input(0)
        for _ in range(testcaseNum):
            nodeNum, nodes = self.get_input()
            self.change_order(nodeNum, nodes)

if __name__ == "__main__":
    problem = PreorderToPostorder()
    problem.solve()
