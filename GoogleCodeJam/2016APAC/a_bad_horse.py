t = int(raw_input())
for case in xrange(1, t+1):
  num_pairs = int(raw_input())
  pairs = []
  for p in xrange(num_pairs):
    pairs.append(tuple(raw_input().split()))