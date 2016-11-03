known_fib = [None] * 41
known_fib[0] = 0
known_fib[1] = 1

def fib(n):
  if(known_fib[n] is not None):
    return known_fib[n]
  else:
    known_fib[n] = fib(n-1) + fib(n-2)
    return known_fib[n]

print(fib(int(input())))