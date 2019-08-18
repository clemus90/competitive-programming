def main():
    n = int(input())
    if n % 2 == 0:
        print("NO")
    else:
        print("YES")
        currentPair = 0
        offset = 0
        for i in range(2*
        n):
            nextVal = 2 * currentPair + offset
            print(nextVal + 1, end="")
            currentPair = (currentPair + 1) % n
            offset = (offset + 1) % 2
            if (i != 2*n - 1):
                print(" ", end="")
        print()

main()