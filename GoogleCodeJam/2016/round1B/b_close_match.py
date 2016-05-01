t = int(raw_input())

prev_calc = {}

def minimize_abs(coders, jammers):
    #base
    if(len(coders) == 1):
        if coders[0] != '?' and jammers[0] != '?':
            return coders, jammers, abs_diff(coders, jammers)
        elif coders[0] == '?' and jammers[0] != '?':
            return jammers, jammers, 0
        elif coders[0] != '?' and jammers[0] == '?':
            return coders, coders, 0
        else:
            return ['0'], ['0'], 0
    #remember
    if (tuple(coders),tuple(jammers)) in prev_calc:
        return prev_calc[(tuple(coders),tuple(jammers))]
    #recursive
    rem_coders = coders[1:]
    rem_jammers = jammers[1:]
    maxC, minC, maxJ, minJ = maximize(rem_coders), minimize(rem_coders), maximize(rem_jammers), minimize(rem_jammers)

    if coders[0] == '?' and jammers[0] == '?':
        posibles = []
        #both 0
        temp = minimize_abs(rem_coders, rem_jammers)
        posibles.append((['0'] + temp[0], ['0'] + temp[1], temp[2]))

        #C0 = 0 and J0 = 1
        posibles.append((['0']+ maxC, ['1']+minJ, abs_diff(maxC, ['1'] + minJ)))
        #C0 = 1 and J0 = 0
        posibles.append((['1']+ minC, ['0']+maxJ, abs_diff(['1']+minC, maxJ)))
        minimum = min(*[z for x,y,z in posibles])
        for pos in posibles:
            if pos[2] == minimum:
                prev_calc[(tuple(coders),tuple(jammers))] = pos
                return pos

    if coders[0] == '?' and jammers[0] != '?':
        posibles = []
        #c = j
        temp = minimize_abs(rem_coders, rem_jammers)
        posibles.append(([jammers[0]] + temp[0], [jammers[0]] + temp[1], temp[2]))

        #C0 = J0 - 1
        posibles.append(([str(int(jammers[0]) -1) ]+ maxC, [jammers[0]]+minJ, abs_diff([str(int(jammers[0]) -1) ]+ maxC, [jammers[0]]+minJ)))
        #C0 = J0 + 1
        if jammers[0] != '9':
            posibles.append(([str(int(jammers[0]) + 1) ] + minC, [jammers[0]]+maxJ, abs_diff([str(int(jammers[0]) + 1) ] + minC, [jammers[0]]+maxJ)))
        minimum = min(*[z for x,y,z in posibles])
        for pos in posibles:
            if pos[2] == minimum:
                prev_calc[tuple(coders),tuple(jammers)] = pos
                return pos

    if coders[0] != '?' and jammers[0] == '?':
        posibles = []
        #j = c
        temp = minimize_abs(rem_coders, rem_jammers)
        posibles.append(([coders[0]] + temp[0], [coders[0]] + temp[1], temp[2]))

        #J = C - 1
        posibles.append(([coders[0]]+ maxC, [str(int(coders[0])+1)]+minJ, abs_diff([coders[0]]+ maxC, [str(int(coders[0])+1)]+minJ)))
        #J = C + 1
        if coders[0] != '9':
            posibles.append(([coders[0]] + minC, [str(int(coders[0])-1)]+maxJ, abs_diff([coders[0]] + minC, [str(int(coders[0])-1)]+maxJ)))
        minimum = min(*[z for x,y,z in posibles])
        for pos in posibles:
            if pos[2] == minimum:
                prev_calc[(tuple(coders), tuple(jammers))] = pos
                return pos

    if coders[0] != '?' and jammers[0] != '?':
        if coders[0] > jammers[0]:
            temp = ([coders[0]] +minC, [jammers[0]] + maxJ, abs_diff([coders[0]] + minC, [jammers[0]]+maxJ))
            prev_calc[(tuple(coders), tuple(jammers))] = temp
            return temp
        elif coders[0] < jammers[0]:
            temp = ([coders[0]] +maxC, [jammers[0]] + minJ, abs_diff([coders[0]] + maxC, [jammers[0]]+minJ))
            prev_calc[tuple(coders),tuple(jammers)] = temp
            return temp
        else:
            temp = minimize_abs(rem_coders, rem_jammers)
            prev_calc[tuple(coders),tuple(jammers)] = temp
            return temp

def maximize(num):
    num = num[:]
    for i in xrange(len(num)):
        if num[i] == '?':
            num[i] = '9'
    return num

def minimize(num):
    num = num[:]
    for i in xrange(len(num)):
        if num[i] == '?':
            num[i] = '0'
    return num

def abs_diff(num1, num2):
    val1 = 0
    val2 = 0
    for i, x in enumerate(reversed(num1)):
        val1 += int(x) * (10**i)
    for i, x in enumerate(reversed(num2)):
        val2 += int(x) * (10**i)
    return abs(val1 - val2)

for case in xrange(1, t+1):
    coders, jammers = raw_input().split()
    coders = [x for x in coders]
    jammers = [x for x in jammers]
    coders, jammers, length = minimize_abs(coders, jammers)
    print "Case #{}: {} {}".format(case, ''.join(coders), ''.join(jammers))
