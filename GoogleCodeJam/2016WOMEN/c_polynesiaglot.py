# prev calculation for lv and lc
prev_calc_v = {}
prev_calc_c = {}

# how many valid words of length 'length' are there that began with a vowel
def lv(length, v, c):
    if length == 1:
        return v
    key = (length, v, c)
    if  key in prev_calc_v:
        return prev_calc_v[key]
    else:
        val = v * (lv(length-1, v, c) + lc(length-1, v, c))
        prev_calc_v[key] = val
        return val

# how many valid words of length 'length' are there that began with a consonant
def lc(length, v, c):
    if length == 1:
        return 0
    key = (length, v, c)
    if key in prev_calc_c:
        return prev_calc_c[key]
    else:
        val = c * lv(length-1, v, c)
        prev_calc_c[key] = val
        return val

t = int(raw_input())
for case in xrange(1, t+1):
    consonants, vowels, length = map(int, raw_input().split())

    posibilities = lv(length, vowels, consonants) + lc(length, vowels, consonants)

    posibilities = posibilities % (pow(10,9)+7)
    print "Case #{}: {}".format(case, posibilities)
