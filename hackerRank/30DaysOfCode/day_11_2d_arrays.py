def sum_hourglass(arr, row, col):
    sum = 0
    for sub_row in range(row, row+3):
        for sub_col in range(col, col+3):
            sum += arr[sub_row][sub_col]
    sum -= arr[row+1][col]
    sum -= arr[row+1][col+2]
    return sum

arr = [[int(x) for x in input().split()] for i in range(6)]

max_sum = -10 ** 9
for row in range(4):
    for col in range(4):
        curr = sum_hourglass(arr, row, col)
        max_sum = max(max_sum, curr)

print(max_sum)
