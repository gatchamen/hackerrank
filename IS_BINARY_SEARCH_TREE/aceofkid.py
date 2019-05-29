""" Node is defined as
class node:
  def __init__(self, data):
      self.data = data
      self.left = None
      self.right = None
"""
def check_binary_search_tree_(root):
    if root.left is None and root.right is None:
        return True

    if root.left is not None:
        if check_binary_search_tree_(root.left) is False:
            return False


    if root.data < root.left.data or root.data > root.right.data:
        return False

    if root.right is not None:
        if check_binary_search_tree_(root.right) is False:
            return False

    return True
