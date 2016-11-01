def count_inversions(a):
  count_inversions(a, )

t = int(input())
for case in range(t):
  n = int(input())
  arr = map(int, input().split())
  print(count_inversions(arr))