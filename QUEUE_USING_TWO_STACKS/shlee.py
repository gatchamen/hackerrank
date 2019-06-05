class Stack(list):
    def is_empty(self):
        if not self:
            return True
        else:
            return False

    def push(self, x):
        self.append(x)

    def peek(self):
        return self[-1]


class Queue:
    def __init__(self):
        self.s1 = Stack()
        self.s2 = Stack()

    def enqueue(self, x):
        self.s1.push(x)

    def dequeue(self):
        if not self.s2.is_empty():
            return self.s2.pop()
        else:
            while not self.s1.is_empty():
                self.s2.push(self.s1.pop())
            
            return self.s2.pop()

    def peek(self):
        if not self.s2.is_empty():
            return self.s2.peek()
        else:
            while not self.s1.is_empty():
                self.s2.push(self.s1.pop())

            return self.s2.peek()


if __name__=="__main__":
    queue = Queue()

    q = int(input())

    for i in range(q):
        line = input().split()
        t = int(line[0])
        if t == 1:
            x = int(line[1])
            queue.enqueue(x)
        elif t == 2:
            queue.dequeue()
        elif t == 3:
            print(queue.peek())
        