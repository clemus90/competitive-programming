def hasZero(arr):
    for x in arr:
        if x == 0:
            return True
    return False

def countNegatives(arr):
    count = 0
    for x in arr:
        count += 1 if x < 0 else 0
    return count


def countMinSteps(arr):
    minSteps = 0
    for x in arr:
        minSteps += (abs(abs(x) - 1))
    return minSteps

def main():
    ammount = int(input())
    numbers = [int(x) for x in input().split()]
    negCount = countNegatives(numbers)
    steps = countMinSteps(numbers)
    hasZ = hasZero(numbers)
    if negCount % 2 != 0 and not hasZ:
        print(steps + 2)
    else:
        print(steps)


main()