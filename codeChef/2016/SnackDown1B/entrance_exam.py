t = int(raw_input())
for case in xrange(t):
  stud, maxEnroll, numExam, maxPoints = [int(x) for x in raw_input().split()]
  grades = []
  for s in xrange(stud-1):
    grades.append(reduce(lambda x,y: x+y, [int(x) for x in raw_input().split()]))
  grades.sort(reverse=True)
  grades = grades[:maxEnroll]
  myGrades = 0
  if numExam != 1:
    myGrades = reduce(lambda x,y: x+y, [int(x) for x in raw_input().split()])
  else:
    raw_input()
  needed = grades[-1] - myGrades
  if needed <= 0 or len(grades) < maxEnroll:
    print 0
  else:
    if(needed + 1) > maxPoints:
      print "Impossible"
    else:
      print needed + 1