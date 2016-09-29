a = input().lower()
b = input().lower()

a_letter_count = [0] * 26
b_letter_count = [0] * 26

a_pos = ord('a')

for letter in a:
  a_letter_count[ord(letter)-a_pos]+= 1

for letter in b:
  b_letter_count[ord(letter)-a_pos]+= 1

cont = 0
for i in range(26):
  cont += abs(a_letter_count[i] - b_letter_count[i])

print(cont)