Q = int(input().strip())
for a0 in range(Q):
  n = int(input().strip())
  b = input().strip()

  space = False
  counter = {}
  for pos in b:
    if pos == '_':
      space = True
    else:
      counter[pos] = counter.get(pos,0) + 1
  if space:
    posible = True
    for key in counter:
      if counter[key] == 1:
        posible = False
        break
    print('YES' if posible else 'NO')
  else:
    alreadyHappy = True
    for i in range(n):
      goodNeighbor = False
      if i > 0:
        if b[i] == b[i-1]: goodNeighbor = True
      if i < (n-1):
        if b[i] == b[i+1]: goodNeighbor = True
      if not goodNeighbor:
        alreadyHappy = False
        break
    print ('YES' if alreadyHappy else 'NO')