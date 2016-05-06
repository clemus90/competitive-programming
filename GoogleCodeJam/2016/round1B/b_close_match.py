def bestScores(cod, jam):
    size = len(cod) #same as jam
    if size == 0:
        return '','',0
    if size == 1:
        if cod == '?' and jam == '?':
            return '0', '0', 0
        elif cod == '?' and jam != '?':
            return jam, jam, 0
        elif cod != '?' and jam == '?':
            return cod, cod, 0
        elif cod != '?' and jam != '?':
            return cod, jam, absDifference(cod,jam)

    for i in xrange(size):
        if cod[i] == '?' and jam[i] == '?':
            #both 0
            bestSoFar = None
            codPrefix = cod[:i]
            jamPrefix = jam[:i]
            codSufix, jamSufix, bestSoFar = bestScores(cod[i+1:], jam[i+1:])
            codCurrent, jamCurrent = codPrefix + '0' + codSufix, jamPrefix + '0' + jamSufix
            #cod 0 jam 1
            codSufix, jamSufix = maxScore(cod[i+1:]), minScore(jam[i+1:])
            tempDiff = absDifference(codSufix, '1'+jamSufix)
            if tempDiff < bestSoFar:
                bestSoFar = tempDiff
                codCurrent, jamCurrent = codPrefix + '0' + codSufix, jamPrefix + '1' + jamSufix
            #cod 1 jam 0
            codSufix, jamSufix = minScore(cod[i+1:]), maxScore(jam[i+1:])
            tempDiff = absDifference('1'+codSufix, jamSufix)
            if tempDiff < bestSoFar:
                bestSoFar = tempDiff
                codCurrent, jamCurrent = codPrefix + '1' + codSufix, jamPrefix + '0' + jamSufix
            return codCurrent, jamCurrent, bestSoFar

        elif cod[i] == '?' and jam[i] != '?':
            bestSoFar = None
            codPrefix = cod[:i]
            jamPrefix = jam[:i]
            #cod = jam - 1
            if(jam[i]!='0'):
                codSufix, jamSufix = maxScore(cod[i+1:]), minScore(jam[i+1:])
                bestSoFar = absDifference(codSufix, '1'+jamSufix)
                codCurrent, jamCurrent = codPrefix + str(int(jam[i]) - 1) + codSufix, jamPrefix + jam[i] + jamSufix

            #cod = jam
            codSufix, jamSufix, tempDiff = bestScores(cod[i+1:], jam[i+1:])
            if bestSoFar==None or tempDiff < bestSoFar:
                bestSoFar = tempDiff
                codCurrent, jamCurrent = codPrefix + jam[i] + codSufix, jamPrefix + jam[i] + jamSufix

            #cod = jam + 1
            if(jam[i]!='9'):
                codSufix, jamSufix = minScore(cod[i+1:]), maxScore(jam[i+1:])
                tempDiff = absDifference('1'+codSufix, jamSufix)
                if tempDiff < bestSoFar:
                    bestSoFar = tempDiff
                    codCurrent, jamCurrent = codPrefix + str(int(jam[i]) + 1) + codSufix, jamPrefix + jam[i] + jamSufix
            return codCurrent, jamCurrent, bestSoFar

        elif cod[i] != '?' and jam[i] == '?':
            bestSoFar = None
            codPrefix = cod[:i]
            jamPrefix = jam[:i]
            #jam = cod - 1
            if(cod[i]!='0'):
                codSufix, jamSufix = minScore(cod[i+1:]), maxScore(jam[i+1:])
                bestSoFar = absDifference('1'+codSufix, jamSufix)
                codCurrent, jamCurrent = codPrefix + cod[i] + codSufix, jamPrefix + str(int(cod[i]) - 1) + jamSufix

            #jam = cod
            codSufix, jamSufix, tempDiff = bestScores(cod[i+1:], jam[i+1:])
            if bestSoFar==None or tempDiff < bestSoFar:
                bestSoFar = tempDiff
                codCurrent, jamCurrent = codPrefix + cod[i] + codSufix, jamPrefix + cod[i] + jamSufix
            #jam = cod + 1
            if(cod[i]!='9'):
                codSufix, jamSufix = maxScore(cod[i+1:]), minScore(jam[i+1:])
                tempDiff = absDifference(codSufix, '1'+jamSufix)
                if tempDiff < bestSoFar:
                    bestSoFar = tempDiff
                    codCurrent, jamCurrent = codPrefix + cod[i] + codSufix, jamPrefix + str(int(cod[i])+1) + jamSufix
            return codCurrent, jamCurrent, bestSoFar

        elif cod[i] != '?' and jam[i] != '?' and cod[i] != jam[i]:
            if int(cod[i]) > int(jam[i]):
                codCurrent = cod[:i+1] + minScore(cod[i+1:])
                jamCurrent = jam[:i+1] + maxScore(jam[i+1:])
            else:
                codCurrent = cod[:i+1] + maxScore(cod[i+1:])
                jamCurrent = jam[:i+1] + minScore(jam[i+1:])
            return codCurrent, jamCurrent, absDifference(codCurrent,jamCurrent)
    return cod, jam, 0

def absDifference(cod, jam): 
    if len(cod) == 0 and len(jam)==0:
        return 0
    if (len(cod) == 1 and len(jam) == 0) or (len(cod)==0 and len(jam)==1):
        return 10
    return abs(int(cod) - int(jam))

def maxScore(score):
    return score.replace('?','9')

def minScore(score):
    return score.replace('?','0')

t = int(raw_input())

for case in xrange(1, t+1):
    coders, jammers = raw_input().split()
    coders, jammers, bestDiff = bestScores(coders, jammers)
    print "Case #{}: {} {}".format(case, coders, jammers)
