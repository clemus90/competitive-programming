n = int(input().strip())
for i in range(n):
  st = input().strip()
  groups = {'{': '}', '(': ')' , '[': ']'}
  stack = []
  wellFormed = True
  for c in st:
    if c in groups:
      stack.append(c)
    else:
      if (len(stack) == 0 or groups[stack.pop()] != c ):
        wellFormed = False
        break
  if len(stack) > 0:
    wellFormed = False
  
  print('YES' if wellFormed else 'NO')