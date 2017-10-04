# AVL 树是带平衡条件的二叉查找树，一般要求每个节点的左子树和右子树的高度最多差 1（空树的高度定义为 -1）
# 在高度为 h 的 AVL 树中，最少的节点数 S(h) 由 S(h) = S(h-1) + S(h-2) + 1 得出，其中 S(0)=1, S(1)=2


class Node(object):
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None
        self.height = 0


class AVLTree(object):
    def __init__(self):
        self.root = None

    def find(self, key):
        if self.root is None:
            return None
        else:
            return self._find(key, self.root)

    def _find(self, key, node):
        if node is None:
            return None
        elif key < node.key:
            return self._find(key, node.left)
        elif key > node.key:
            return self._find(key, node.right)
        else:
            return node

    def find_min(self):
        if self.root is None:
            return None
        else:
            return self._find_min(self.root)

    def _find_min(self, node):
        if node.left:
            return self._find_min(node.left)
        else:
            return node

    def find_max(self):
        if self.root is None:
            return None
        else:
            return self._find_max(self.root)

    def _find_max(self, node):
        if node.right:
            return self._find_max(node.right)
        else:
            return node

    def height(self, node):
        if node is None:
            return -1
        else:
            return node.height

