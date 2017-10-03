class Node:
    __slots__ = ['_item', '_next']

    def __init__(self, item):
        self._item = item
        self._next = None

    def get_item(self):
        return self._item

    def get_next(self):
        return self._next

    def set_item(self, new_item):
        self._item = new_item

    def set_next(self, new_next):
        self._next = new_next


class SingleLinkedList:
    def __init__(self):
        self._head = None
        self._size = 0

    def is_empty(self):
        return self._head is None

    def add(self, item):
        """Add item at the front of linked list"""
        temp = Node(item)
        temp.set_next(self._head)
        self._head = temp

    def append(self, item):
        temp = Node(item)
        if self.is_empty():
            self._head = temp
        else:
            current = self._head
            while current.get_next():
                current = current.get_next()
            current.set_next(temp)

    def search(self, item):
        current = self._head
        found_item = False
        while current and not found_item:
            if current.get_item() == item:
                found_item = True
            else:
                current = current.get_next()
        return found_item

    def index(self, item):
        current = self._head
        count = 0
        found = None
        while current and not found:
            count += 1
            if current.get_item() == item:
                found = True
            else:
                count = current.get_next()
        if found:
            return count
        else:
            raise ValueError("%s is not in linkedlist" % item)

    def remove(self, item):
        current = self._head
        pre = None
        while current:
            if current.get_item() == item:
                if not pre:
                    self._head = current.get_next()
                else:
                    pre.set_next(current.get_next())
                break
            else:
                pre = current
                current = current.get_next()

    def insert(self, position, item):
        if position <= 1:
            self.add(item)
        elif position > self._size:
            self.append(item)
        else:
            temp = Node(item)
            count = 1
            pre = None
            current = self._head
            while count < position:
                count += 1
                pre = current
                current = current.get_next()
            pre.set_next(temp)
            temp.set_next(current)
