t = int(raw_input())
for case in xrange(1, t+1):
  dancers, k_dancer, turns = map(int, raw_input().split())
  turns = turns % dancers
  pos_k = None
  dancer_left = None

  if k_dancer % 2 == 0:
    pos_k = ((k_dancer - 1) - turns) % dancers
    dancer_left = (pos_k - turns) % dancers
  else:
    pos_k = ((k_dancer - 1) + turns) % dancers
    dancer_left = (pos_k + turns) % dancers

  dancer_left = dancer_left or dancers
  dancer_right = ((dancer_left + 2) % dancers) or dancers

  print "Case #{}: {} {}".format(case, dancer_right, dancer_left)
