size = int(input())
array = [int(x) for x in input().split()]
switch_count = 0
for i in range(size-1):
    for j in range(size-1-i):
        if(array[j] > array[j+1]):
            switch_count+=1
            (array[j], array[j+1]) = (array[j+1], array[j])
print(switch_count)