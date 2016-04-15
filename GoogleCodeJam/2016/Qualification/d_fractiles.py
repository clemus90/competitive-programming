t = int(raw_input())

for case in xrange(1, t+1):
    k, c, s = map(int, raw_input().split())
    result = None
    if c * s < k:
        result = "IMPOSSIBLE"
    else:
        to_discarted = 0
        uncovered = []
        while to_discarted < k:
            pos = 0
            for x in reversed(range(c)):
                if to_discarted < k:
                    pos += to_discarted * pow(k,x)
                    to_discarted += 1
            uncovered.append(pos + 1)
        result = ' '.join(map(str, uncovered))
    print "Case #{}: {}".format(case, result)
