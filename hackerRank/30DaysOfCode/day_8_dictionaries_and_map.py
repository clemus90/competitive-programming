tam = int(input())
direc = {}
for i in range(tam):
    entry = input().split()
    direc[entry[0]] = entry[1]

while True:
    try:
        query = input()
    except:
        break
    if query is None:
        break
    if query in direc:
        print("{0}={1}".format(query, direc[query]))
    else:
        print("Not found")
