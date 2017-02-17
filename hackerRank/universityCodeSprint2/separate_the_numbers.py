def getBeautifulNumber(s):
    for i in range(1, len(s)//2 + 1):
        prefix = int(s[:i])
        if isBeautifulNumber(prefix, s[i:]):
            return prefix

def isBeautifulNumber(prevNum, rest):
    if len(rest) == 0:
        return True
    if len(rest) >= 1 and rest[0] == '0':
        return False
    num = -1
    index = -1
    numberFound = False
    for i in range(1, len(rest) + 1):
        num = int(rest[:i])
        if (num == prevNum + 1):
            numberFound = True
            index = i
            break
    if(numberFound):
        return isBeautifulNumber(num, rest[index:])
    else:
        return False
        


q = int(input())
for i in range(q):
    num = input()
    result = getBeautifulNumber(num)
    if(result):
        print("YES " + str(result))
    else:
        print("NO")
