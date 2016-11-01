def longest_shared_prefix(s1, s2):
  size = min(len(s1), len(s2))
  for i in range(size):
    if s1[i] != s2[i]:
      return i
  return size

initial = input()
desired = input()
operations = int(input())

shared_prefix_size = longest_shared_prefix(initial, desired)

operations_needed = len(initial) + len(desired) - 2 * shared_prefix_size

remaining_op = operations - operations_needed

print("Yes" if remaining_op >= 0 and (operations >= (len(initial) + len(desired)) or remaining_op % 2 == 0) else "No")
