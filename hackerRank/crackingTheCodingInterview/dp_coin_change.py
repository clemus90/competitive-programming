n,m = list(map(int, input().split()))
coins = list(map(int, input().split()))
coins.sort()
num_ways = [0] * (n+1)
#there is one way of complete 0 change with any coin; not using any
num_ways[0] = 1
for x in coins:
    for i in range (x, n+1):
        num_ways[i] += num_ways[i-x]
print(num_ways[n])
