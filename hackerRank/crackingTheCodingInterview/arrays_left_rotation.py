n, d = map(int, input().split())
arr = input().split()
arr = arr[d:] + arr[:d]
print(' '.join(arr))
