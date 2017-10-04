class BinaryTree(object):
    def __init__(self, item):
        self.key = item
        self.left_child = None
        self.right_child = None

    def insert_left(self, item):
        if self.left_child is None:
            self.left_child = BinaryTree(item)
        else:
            tmp = BinaryTree(item)
            tmp.left_child = self.left_child
            self.left_child = tmp

    def insert_right(self, item):
        if self.right_child is None:
            self.right_child = BinaryTree(item)
        else:
            tmp = BinaryTree(item)
            tmp.right_child = self.right_child
            self.right_child = tmp


class Travelsal:
    def pre_order(self, tree, node_list=None):
        if node_list is None:
            node_list = []
        if tree:
            node_list.append(tree.key)
            self.pre_order(tree.left_child, node_list)
            self.pre_order(tree.right_child, node_list)
        return node_list

    def in_order(self, tree):
        if tree:
            self.in_order(tree.left_child)
            print(tree.key)
            self.in_order(tree.right_child)

    def post_order(self, tree):
        if tree:
            for key in self.post_order(tree.left_child):
                yield key
            for key in self.post_order(tree.right_child):
                yield key
            yield tree.key

