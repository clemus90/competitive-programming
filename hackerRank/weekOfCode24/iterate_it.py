#NOT FOR ALL TEST CASES
def binary_search(arr, n, ini, end):
  while(True):
    if ini == end:
      if len(arr) == 0:
        return {'founded': False, 'insert': 0} 
      if len(arr) == end:
        return {'founded': False, 'insert': len(arr)} 
      if arr[ini] == n:
        return {'founded': True, 'pos': ini}
      else:
        return {'founded': False, 'insert': ini if arr[ini] > n else ini + 1}

    else:
      half = ini + ((end - ini) // 2)
      if arr[half] == n:
        return {'founded': True, 'pos': ini}
      elif n < arr[half]:
        #special case because of truncated division
        if(ini == half):
          end = half
        else:
          end = half - 1
      else:
        ini = half + 1

def to_ordered_set(arr):
  arr_set = []
  for x in arr:
    insert_in_set(arr_set, x)
  return arr_set

def insert_in_set(arr, x):
  where = binary_search(arr, x, 0, len(arr))
  if(not where['founded']):
    arr.insert(where['insert'], x)


def get_substracts(arr):
  i = 0
  subs = []
  while i < len(arr):
    #ignore same
    index = i + 1
    while(index<len(arr) and arr[i]==arr[index]):
      index += 1
    next_sub = next_i = index
    while(next_sub < len(arr)):
      substract = abs(arr[i]-arr[next_sub])
      insert_in_set(subs, substract)
      #just one substraction per repetition
      index = next_sub + 1
      while(index<len(arr) and arr[next_sub]==arr[index]):
        index += 1
      next_sub = index
    i = next_i
  return subs


n = input() #ignored
A = map(int, input().split())
a_set = to_ordered_set(A)
i = 0
while(len(a_set)>0):
  a_set = (get_substracts(a_set))
  i+= 1
  print(a_set)  
print(i)

