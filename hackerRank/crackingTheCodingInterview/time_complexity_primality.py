def checkPrime(primes, test):
  i = 0
  isPrime = True
  while(i<= len(primes) and primes[i]<= int(test ** (1/2))):
    if(test % primes[i] == 0):
      isPrime = False
      break
    i+=1
  return isPrime

primes = [2]
i = 3
lastTest = int((2 * (10**9))**(1/2)) #Square Root of 2 * 10 ^9
#build an array of primes up to the lastTest
while(i<=lastTest):
  if(checkPrime(primes, i)):
    primes.append(i)
  i+=1

n = int(input())
for i in range(n):
  test = int(input())
  if(test <= lastTest):
    print("Prime" if test in primes else "Not prime")
  else:
    print("Prime" if checkPrime(primes, test) else "Not prime")

