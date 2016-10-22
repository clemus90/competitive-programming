class node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def check_binary_search_tree_(root):
  if root is None:
    return True
  if not check_all_lower_(root.left, root.data):
    return False
  if not check_all_greater_(root.right, root.data):
    return False
  return check_binary_search_tree_(root.left) and \
    check_binary_search_tree_(root.right)

def check_all_lower_(root, data):
  if(root is None):
    return True
  return check_all_lower_(root.left, data) and root.data < data and \
    check_all_lower_(root.right, data)

def check_all_greater_(root, data):
  if(root is None):
    return True
  return check_all_greater_(root.left, data) and root.data > data and \
    check_all_greater_(root.right, data)



r = node(3)
r.left = node(5)
r.left.left = node(1)
r.left.right = node(4)
r.right = node(2)
r.right.left = node(6)

print(check_binary_search_tree_(r))