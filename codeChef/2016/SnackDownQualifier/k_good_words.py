def best_deletion(k, char_count):
  current_k = char_count[-1] - char_count[0]
  if current_k <= k:
    return 0
  else:
    count_first = 0
    for x in xrange(1,len(char_count)):
      if char_count[x] != char_count[x-1]:
        count_first = x
        break

    deleting_first = (count_first * char_count[0]) + best_deletion(k, char_count[count_first:])
    
    decreasing_last = 0

    plus_k = char_count[0] + k
    for x in xrange(count_first,len(char_count)):
      if plus_k < char_count[x]:
        decreasing_last += char_count[x] - plus_k

    return min(deleting_first, decreasing_last)

t = int(raw_input())

for case in xrange(t):
  word, k = raw_input().split()
  k = int(k)
  char_count = [0] * 26
  for c in word:
    char_count[ord(c) - ord('a')] += 1
  char_count = sorted([x for x in char_count if x != 0])
  
  print best_deletion(k, char_count[:])
