def check_size(matrix, visited, i, j):
    rows = len(matrix)
    cols = len(matrix[0])
    cont = 1
    visited.add(cols*i + j)
    for i2 in range(i-1,i+2):
        for j2 in range(j-1,j+2):
            if i == i2 and j == j2:
                continue
            if 0<=i2<rows and 0<=j2<cols and matrix[i2][j2] == 1 and not (cols*i2 + j2) in visited:
                cont += check_size(matrix, visited, i2, j2)
    return cont



rows = int(input())
cols = int(input())
matrix = [[int(y) for y in input().split()] for x in range(rows)]

visited = set()

max_size = 0
for i in range(rows):
    for j in range(cols):
        if matrix[i][j] == 1 and not (cols*i + j) in visited:
            temp = check_size(matrix, visited, i, j)
            max_size = max(temp, max_size)

print(max_size)
