class Stack(list):
    push = list.append

    def is_empty(self):
        if not self:
            return True
        else:
            return False

    def peek(self):
        return self[-1]


if __name__=="__main__":

    stack = Stack()

    n = int(input())
    
    for i in range(n):
        t=[_ for _ in input().strip().split()]
        if t[0]=='1':
                if stack.is_empty():
                    stack.push(t[1])
                else:
                    stack.push(stack.peek() + t[1])
        elif t[0]=='2':
                s = stack.peek() 
                s = s[:len(s) - int(t[1])]
                stack.push(s)  
        elif t[0]=='3':
                s = stack.peek()
                print(s[int(t[1])-1])
        elif t[0]=='4':
                stack.pop()

