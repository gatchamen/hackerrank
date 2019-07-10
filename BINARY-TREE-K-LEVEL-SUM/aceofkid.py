import sys

class Node(object):

    def __init__(self,data, level):
        self.data = data
        self.level = level
        self.left = self.right = None

class BinaryTree(object):

    def __init__(self):
        self.root = None

    def insert(self, data, level):
        self.root = self._insert(self.root, data)

    def _insert(self, node, data, level):
        if node is None:
            node = Node(data)
        else:
            if node.left is None:
                node.left = self._insert(node.left, data)
            else:
                node.right = self._insert(node.right, data)
        return node

    def traverse_preorder(self, node):
        if node is not None:
            if node == self.root:
                print(node.data)
            else:
                print(node.data, end=' ')
            self.traverse_postorder(node.left)
            self.traverse_postorder(node.right)

class BinaryTreeKlevelSum(object):
    def __init__(self):
        pass

    def get_input(self, inputType=1):
        """(0(5(6()())(4()(9()())))(7(1()())(3()())))"""
        """(0(5(61()())(4()(93()())))(7(111()())(3()())))"""
        if inputType == 0:
            T = int(sys.stdin.readline().strip())
            return T
        else:
            treeStr = sys.stdin.readline().strip()
            return treeStr

    def build_btree(self, flattree, nodes):
        bst = BinaryTree()

    def calculate_levelsum(self, flattree, level):
        sumLevel = 0
        currentLevel = -1

        for ch in re.split("(\(|\))", flattree):
            if ch is '(':
                currentLevel += 1
            elif ch is ')':
                currentLevel -= 1
            elif ch is '':
                pass
            else:
                if currentLevel == level:
                    sumLevel += int(ch)

        return sumLevel

    def solve(self):
        testcaseNum = self.get_input(0)
        for _ in range(testcaseNum):
            testLevel = self.get_input(0)
            flatTree = self.get_input()
            result = self.calculate_levelsum(flatTree, testLevel)
            print(result)

if __name__ == "__main__":
    problem = BinaryTreeKlevelSum()
    problem.solve()
