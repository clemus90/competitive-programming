import math

n, m = map(int, input().split())
m -= 1
first_row=[int(x) for x in input().split()]
result_row = [None for x in range(n)]
while(m):
  last_2_power = int(math.log(m, 2))
  if(last_2_power == 0):
    last_2_power = 1
  m -= last_2_power

  for i in range(n):
    result_row[i] = first_row[i] ^ first_row[(i + last_2_power) % n]
  result_row, first_row = first_row, result_row

  print(' '.join(map(str,first_row)))
