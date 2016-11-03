n_of_ways = [None] * 37

n_of_ways[0] = 1

def number_of_ways(n):
  if(n<0):
    return 0
  if n_of_ways[n] is None:
    n_of_ways[n] = number_of_ways(n-3) + number_of_ways(n-2) + number_of_ways(n-1)
  return n_of_ways[n]

cases = int(input())

for i in range(cases):
  height = int(input())
  print(number_of_ways(height))