numElem, numQueries = map(int, raw_input().split())
arr = map(int, raw_input().split())
minVal = min(arr)
maxVal = max(arr)
for x in xrange(numQueries):
  query = int(raw_input())
  if minVal <= query <= maxVal:
    print "Yes"
  else:
    print "No"