t = int(raw_input())

for case in xrange(t):
  size = int(raw_input())
  arr = [int(x) for x in raw_input().split()]

  max_ending_here = max_so_far = arr[0]
  max_replacing = 0
  for x in arr[1:]:
      max_replacing = max(max_ending_here, max_replacing + x)
      max_ending_here = max(x, max_ending_here + x)
      max_so_far = max(max_so_far, max_ending_here, max_replacing)
  print max_so_far
