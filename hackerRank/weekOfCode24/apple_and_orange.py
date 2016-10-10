s,t = sorted(map(int,input().split()))
a,b = map(int,input().split())
m,n = map(int,input().split())

criteria = lambda coor: s <= coor <= t;
apples = [int(x) + a for x in input().split() if criteria(int(x) + a)]
oranges = [int(x) + b for x in input().split() if criteria(int(x) + b)]

print(len(apples))
print(len(oranges))