class MyQueue(object):
    def __init__(self):
        self.stack1 = []
        self.stack2 = []
    
    def peek(self):
        if(len(self.stack2) == 0):
            self.fillStack2()
        if(len(self.stack2) > 0):
            return self.stack2[-1]
        return None

        
    def pop(self):
        if(len(self.stack2) == 0):
            self.fillStack2()
        if(len(self.stack2) > 0):
            return self.stack2.pop()
        return None
        
    def put(self, value):
        self.stack1.append(value)

    def fillStack2(self):
        while(self.stack1):
            self.stack2.append(self.stack1.pop())
        

queue = MyQueue()
t = int(input())
for line in range(t):
    values = map(int, input().split())
    values = list(values)
    if values[0] == 1:
        queue.put(values[1])        
    elif values[0] == 2:
        queue.pop()
    else:
        print(queue.peek())
        
