t = int(raw_input())
for case in xrange(1,t+1):
    n = int(raw_input())
    lists = []
    for x in xrange((2*n) - 1):
        lists.append(map(int, raw_input().split()))
    # every number should appear even times, so the numbers that appears odd times are the ones missing
    times = {}
    for x in lists:
        for y in x:
            times[y] = times.get(y,0) + 1

    missing = []
    for k, value in times.items():
        if value % 2 != 0:
            missing.append(k)

    missing.sort()
    print "Case #{}: {}".format(case, ' '.join(map(str,missing)))
