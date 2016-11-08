def toBin(num):
    curr = ""
    while(num):
        curr += str(num % 2)
        num //= 2
    return curr

def longestOneSeq(st):
    longest = 0
    curr = 0
    for x in st:
        if(int(x)):
            curr += 1
            if curr > longest:
                longest = curr
        else:
            curr = 0
    return longest


n = int(input())
print(longestOneSeq(toBin(n)))
