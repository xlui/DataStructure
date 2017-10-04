class BinarySearchTree(object):
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None

    def find(self, item):
        if item == self.key:
            return self
        elif item < self.key and self.left:
            return self.left.find(item)
        elif item > self.key and self.right:
            return self.right.find(item)
        else:
            return None

    def find_min(self):
        # 从根节点开始只要有左儿子就向左进行查找，终止点是最小元素
        if self.left:
            return self.left.find_min()
        else:
            return self

    def find_max(self):
        # 从根节点开始只要有右儿子就向右进行查找，终止点是最大元素，该函数没有用到递归
        tree = self
        if tree:
            while tree.right:
                tree = tree.right
        return tree

    def insert(self, item):
        # 先用 find 查找，如果找到，则什么都不做。如果没找到则将其插入遍历路径的最后一点
        if item < self.key:
            if self.left:
                self.left.insert(item)
            else:
                tree = BinarySearchTree(item)
                self.left = tree
        elif item > self.key:
            if self.right:
                self.right.insert(item)
            else:
                tree = BinarySearchTree(item)
                self.right = tree

    def delete(self, item):
        # 参考 http://www.cnblogs.com/linxiyue/p/3624597.html
        # 有三种情况
        # 第一种：节点是树叶，直接删除
        # 第二种：节点只有一个儿子，将该节点的 parent 指向节点的儿子
        # 第三种：节点有两个儿子，用其又子树的最小数据代替此节点的数据，并将其右节点的最小数据删除
        if self.find(item):
            if item < self.key:
                # 分情况进入不同递归
                self.left = self.left.delete(item)
                return self
            elif item > self.key:
                # 分情况进入不同递归
                self.right = self.right.delete(item)
                return self
            elif self.left and self.right:
                # 找到元素并且该元素有左右子节点，第三种情况
                key = self.right.find_min().key
                self.key = key
                self.right = self.right.delete(key)
                # 删除该元素节点右子树中最小元素并且把该元素节点的值设为右子树最小值
                return self
            else:
                # 找到元素且元素只有一个子树或者没有子树
                # 直接跳过该子树
                if self.left:
                    return self.left
                else:
                    return self.right
        else:
            # 未在树中找到该元素
            return self