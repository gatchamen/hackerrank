""" Node is defined as
class node:
  def __init__(self, data):
      self.data = data
      self.left = None
      self.right = None
"""

def max(root):
    if root is None:
        return None
    
    l = max(root.left)
    r = max(root.right)
    
    data = root.data
    if l is not None and l > data:
        data = l
    if r is not None and r > data:
        data = r
        
    return data

def min(root):
    if root is None:
        return None
    
    l = min(root.left)
    r = min(root.right)
    
    data = root.data
    if l is not None and l < data:
        data = l
    if r is not None and r < data:
        data = r
        
    return data


def check_binary_search_tree_(root):
    if root is None:
        return True
   
    if root.left is not None and max(root.left) >= root.data:
        return False
    
    if root.right is not None and min(root.right) <= root.data:
        return False
    
    return check_binary_search_tree_(root.left) and check_binary_search_tree_(root.right)

