class Heap:

  def __init__(self):
    self.data = [None] * 10
    self.size = 0

  def checkValidAddition(self):
    if self.size == len(self.data):
      self.data = self.data + [None] * 10

  def getLeftChildIndex(self, index):
    return index*2 + 1

  def getRightChildIndex(self, index):
    return index*2 + 2

  def getParentIndex(self, index):
    return (index - 1) // 2

  def hasLeftChild(self, index):
    return self.getLeftChildIndex(index) < self.size

  def hasRightChild(self, index):
    return self.getRightChildIndex(index) < self.size

  def hasParent(self, index):
    return self.getParentIndex(index) >= 0

  def getLeftChild(self, index):
    return self.data[self.getLeftChildIndex(index)]

  def getRightChild(self, index):
    return self.data[self.getRightChildIndex(index)]

  def getParent(self, index):
    return self.data[self.getParentIndex(index)]

  def push(self, item):
    self.checkValidAddition()
    self.data[self.size] = item
    index = self.size;
    while self.hasParent(index):
      parent = self.getParent(index)
      parentIndex = self.getParentIndex(index)
      if self.should_be_parent(parent, self.data[index]):
        break
      self.data[index], self.data[parentIndex] = self.data[parentIndex], self.data[index]
      index = parentIndex
    self.size += 1

  def peek(self):
    if self.size > 0:
      return self.data[0]

  def pop(self):
    to_return = self.data[0];
    self.data[0] = self.data[self.size-1]
    self.size -= 1
    index = 0;
    while(self.hasLeftChild(index)):
      index_to_swap = self.getLeftChildIndex(index)
      if(self.hasRightChild(index) and (self.should_be_parent(self.getRightChild(index), self.getLeftChild(index)))):
        index_to_swap = self.getRightChildIndex(index)
      if(self.should_be_parent(self.data[index_to_swap], self.data[index])):
        self.data[index_to_swap], self.data[index] = self.data[index], self.data[index_to_swap]
        index = index_to_swap
      else:
        break
    return to_return

class MinHeap(Heap):
  def should_be_parent(self, root, child):
    return root < child

class MaxHeap(Heap):
  def should_be_parent(self, root, child):
    return root > child

n = int(input())
mins = MaxHeap()
maxs = MinHeap()
for i in range(n):
  data = int(input())
  if(maxs.size < mins.size):
    maxs.push(data)
  else:
    mins.push(data)
  #balance
  if(mins.size >= 1 and maxs.size>= 1):
    top_mins = mins.peek()
    top_maxs = maxs.peek()
    while(top_mins > top_maxs):
      mins.pop()
      maxs.pop()
      mins.push(top_maxs)
      maxs.push(top_mins)
      top_mins = mins.peek()
      top_maxs = maxs.peek()
  running_median = None
  if(mins.size > maxs.size):
    running_median = mins.peek()
  else:
    running_median = (maxs.peek() + mins.peek())/2
  print('%.1f' % running_median)
