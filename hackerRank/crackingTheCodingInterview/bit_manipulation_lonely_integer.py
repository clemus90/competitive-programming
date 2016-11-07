n = int(input())
lonely = 0
for x in input().split():
    lonely ^= int(x)
print(lonely)
