nums = [int(x) for x in input().split()]
suma = 0
for x in nums:
  suma += x

sums_without = [suma - x for x in nums]
print(min(*sums_without), max(*sums_without))