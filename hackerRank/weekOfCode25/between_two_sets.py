def gcd(a, b):
  if(a == 0):
    return b
  if(b == 0):
    return a
  return(gcd(b, a%b))

def lcm(a, b):
  return int(a*b / gcd(a,b))

n, m = map(int, input().split())
A = map(int, input().split())
B = map(int, input().split())

gcd_general = lcm_general = None

for x in A:
  if(lcm_general is None):
    lcm_general = x
  else:
    lcm_general = lcm(lcm_general, x)

for x in B:
  if(gcd_general is None):
    gcd_general = x
  else:
    gcd_general = gcd(gcd_general, x)

count_divisors = 0
multiples = lcm_general
while(multiples <= gcd_general):
  if(gcd_general % multiples == 0):
    count_divisors+= 1
  multiples += lcm_general

print(count_divisors)