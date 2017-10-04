class Queue(object):
    def __init__(self):
        self.queue = []

    def is_empty(self):
        return self.size() == 0

    def size(self):
        return len(self.queue)

    def enqueue(self, item):
        self.queue.append(item)

    def dequeue(self):
        if self.queue:
            value = self.queue[0]
            self.queue.remove(value)
            return value
        else:
            raise IndexError("Queue is empty!")
