def search(a, val):
    return binary_search(a, val, 0, len(a)-1)

def binary_search(a, val, left, right):
    if(left > right):
        return -1
    mid = (left + right) // 2
    if a[mid][1] == val:
        return a[mid][0]
    if a[mid][1] > val:
        return binary_search(a,val,left,mid-1)
    if a[mid][1] < val:
        return binary_search(a,val,mid+1,right)

t = int(input())
for case in range(t):
    m = int(input())
    n = int(input())
    cost = [int(x) for x in input().split()]
    enumerated_cost = [(i, cost[i]) for i in range(len(cost))]
    enumerated_cost = sorted(enumerated_cost, key= lambda x: x[1])
    for i in range(len(enumerated_cost)):
        second_index = search(enumerated_cost[:i]+enumerated_cost[i+1:], m-enumerated_cost[i][1])
        if(second_index != -1):
            print(min(enumerated_cost[i][0],second_index) + 1, max(enumerated_cost[i][0],second_index) + 1)
            break
