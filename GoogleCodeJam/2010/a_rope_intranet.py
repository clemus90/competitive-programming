n = int(raw_input())
for case in xrange(1, n+1):
    num_wires = int(raw_input())
    wires = []
    for i in xrange(num_wires):
        b1, b2 = raw_input().split()
        wires.append((int(b1), int(b2)))
    wires.sort()
    intersections = 0
    for i, wire in enumerate(wires):
        for j in xrange(i):
            if wires[j][1] > wire[1]: intersections += 1

    print "Case #{}: {}".format(case, intersections)
