import sys

class Node(object):

    def __init__(self,data):
        self.data = data
        self.left = self.right = None

class AarryToBST(object):
    def __init__(self):
        self.root = None

    def get_input(self, inputType=1):
        if inputType == 0:
            T = int(sys.stdin.readline().strip())
            return T
        else:
            N = int(sys.stdin.readline().strip())
            arr = list(map(int,sys.stdin.readline().split()))
            return N, arr

    def build_BST(self, node, nodeNum, nodes):
        mid = (nodeNum - 1) // 2
        if node is None and len(nodes) != 0:
            node = Node(nodes[mid])

        if node is not None:
            node.left = self.build_BST(node.left, mid, nodes[0:mid])
            node.right = self.build_BST(node.right, nodeNum - mid - 1, nodes[mid+1:])

        return node

    def traverse_preorder(self, node, result):
        if node is not None:
            result.append(node.data)
            self.traverse_preorder(node.left, result)
            self.traverse_preorder(node.right, result)

    def print_result(self, nodes):
        for index, data in enumerate(nodes, 1):
            if len(nodes) == index:
                print(data)
            else:
                print(data, end=' ')


    def solve(self):
        testcaseNum = self.get_input(0)
        for _ in range(testcaseNum):
            nodeNum, nodes = self.get_input()
            result = []
            self.root = None
            self.root = self.build_BST(self.root, nodeNum, nodes)
            self.traverse_preorder(self.root, result)
            self.print_result(result)


if __name__ == "__main__":
    problem = AarryToBST()
    problem.solve()
