#Solves the problem using PyPy 3

def count_inversions(a):
  return count_inversions_full(a, [None] * len(a), 0, len(a) - 1)


def count_inversions_full(a, temp, left, right):
  if(left >= right):
    return 0
  totalInversion = 0
  middle = (left + right) // 2
  totalInversion += count_inversions_full(a, temp, left, middle)
  totalInversion += count_inversions_full(a, temp, middle + 1, right)
  totalInversion += merge_inversions(a, temp, left, right)
  return totalInversion

def merge_inversions(a,temp, left, right):
  inversions = 0;
  middle = (left + right) // 2
  index = left
  leftIndex = left
  rightIndex = middle + 1
  while(leftIndex <= middle and rightIndex <= right):
    if(a[leftIndex] <= a[rightIndex]):
      temp[index] = a[leftIndex]
      leftIndex+=1
      index+=1
    else:
      temp[index] = a[rightIndex]
      rightIndex+=1
      index+=1
      inversions += (middle + 1)-leftIndex
  if(rightIndex > right):
    temp[index:index+(middle-leftIndex) + 1] = a[leftIndex:middle + 1]
  if(leftIndex > middle):
    temp[index:index+(right-rightIndex) + 1] = a[rightIndex:right + 1]
  a[left:right + 1] = temp[left: right + 1]
  return inversions




t = int(input())
for case in range(t):
  n = int(input())
  arr = list(map(int, input().split()))
  print(count_inversions(arr))