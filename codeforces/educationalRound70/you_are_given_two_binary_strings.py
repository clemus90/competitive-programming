# Educational Codeforces Round 70 - Problem A - You Are Given Two Binary Strings
def leastSignificantBit(bitStr, startingFrom = 0):
    for i in range(startingFrom, len(bitStr)):
        if bitStr[i] == "1":
            return i
    return -1


queries = int(input())
for q in range(queries):
    x = input()[::-1]
    y = input()[::-1]
    least_x = leastSignificantBit(x)
    least_y = leastSignificantBit(y)
    if least_x < least_y:
        least_x = leastSignificantBit(x, least_y)
    print(least_x - least_y)