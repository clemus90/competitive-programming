queries = int(input())
for q in range(queries):
  a, b, d = [int(x) for x in input().split()]
  #check if no movement is needed
  if(d == 0):
    print(0)
  #check if can be achieved in one move
  elif (d//b == 1 and d%b ==0) or (d//a == 1 and d%a == 0):
    print(1)
  #use only giant steps
  else:
    steps_needed = d//b
    if(d%b != 0):
      steps_needed += 1
      if(steps_needed == 1):
        steps_needed += 1
    print(steps_needed)
