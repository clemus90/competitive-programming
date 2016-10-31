
# Solves all but one case, something related with memory allocaded for python
class Trie:
  def __init__(self, is_word=False):
    self.word_count = 0
    self.children = {}

  def add_child(self, letter):
    curr_val = None
    if letter in self.children:
      curr_val = self.children[letter]
      curr_val.word_count += 1
    else:
      self.children[letter] = curr_val = Trie();
      curr_val.word_count = 1
    return curr_val

  def get_child(self, letter):
    if letter in self.children:
      return self.children[letter]

  def __str__(self):
    return str(self.is_word) + str(self.children)

def add_word_to_trie(trie, word):
  last_letter = trie
  for letter in word:
    last_letter = last_letter.add_child(letter)
  last_letter.is_word = True

def find_partial(trie, part):
  from_trie = trie
  for letter in part:
    child = from_trie.get_child(letter)
    if child:
      from_trie = from_trie.children[letter]
    else:
      return 0
  return from_trie.word_count

n = int(input())
tr = Trie()
for x in range(n):
  inp = input().split()
  operation = inp[0]
  parameter = inp[1]

  if operation == 'add':
    add_word_to_trie(tr, parameter)
  if operation == 'find':
    print(find_partial(tr, parameter))