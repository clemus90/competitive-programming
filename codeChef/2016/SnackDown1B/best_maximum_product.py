mod = 10**9 + 7

t = int(raw_input())
for case in xrange(t):
  n, tam = [int(x) for x in raw_input().split()]
  arr = [int(x) for x in raw_input().split()]
  best = None
  current = None
  i = j = 0
  while i != n:
    if i == j:
      current = 1
      for k in xrange(tam):
        temp = arr[(i+k)%n]
        if temp == 0:
          current = 0
          i = j = i+k+1
          break
        else:
          current *= temp
          j+=1
    else:
      new_left = arr[j%n]
      old_right = arr[i%n]
      i+=1
      j+=1
      if new_left == 0:
        current = 0
        i = j = j+1
        break
      else:
        current /= old_right
        current *= new_left
    if best == None or current > best:
      best = current
  print best % mod