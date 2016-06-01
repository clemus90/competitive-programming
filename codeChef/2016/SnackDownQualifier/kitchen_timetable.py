t = int(raw_input())

for case in xrange(t):
  students = int(raw_input())
  turns = [int(x) for x in raw_input().split()]
  required_times = [int(x) for x in raw_input().split()]
  last_use = 0;
  turns_sizes = []
  for time in turns:
    turns_sizes.append(time - last_use)
    last_use = time
  possible = 0
  for i in xrange(students):
    if turns_sizes[i] - required_times[i] >= 0:
      possible += 1
  print possible
