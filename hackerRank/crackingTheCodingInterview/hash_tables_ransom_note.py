import hashlib

class WordHashTable:
  hash_table = {}

  def add_word(self, word):
    hash_dig = hashlib.md5(word.encode()).hexdigest()
    first_set = self.hash_table.get(hash_dig, False)
    if not first_set:
      self.hash_table[hash_dig] = first_set = {word: 0}
    first_set[word] = first_set.get(word,0) + 1


  def delete_word(self,word):
    hash_dig = hashlib.md5(word.encode()).hexdigest()
    first_set = self.hash_table.get(hash_dig, False)
    if not first_set:
      return -1
    remaining = first_set[word] = first_set.get(word,0) - 1
    return remaining


size_mag_words, size_note_words = map(int, input().split())
mag_words = input().split()
note_words = input().split()

ht = WordHashTable()
for word in mag_words:
  ht.add_word(word)

possible_to_build = True

for word in note_words:
  remaining = ht.delete_word(word)
  if(remaining < 0):
    possible_to_build = False
    break

print ('Yes' if possible_to_build else 'No')