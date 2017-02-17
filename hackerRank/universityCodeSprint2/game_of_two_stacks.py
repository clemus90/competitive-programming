number_of_games = int(input())

for game in range(number_of_games):
    values = [int(x) for x in input().split(" ")]
    stack1_size = values[0]
    stack2_size = values[1]
    sum = values[2]
    s1, s2 = [0], [0]
    
    s1.extend([int(x) for x in input().split(" ")])
    s2.extend([int(x) for x in input().split(" ")])

    for i in range(1, len(s1)):
        s1[i] = s1[i-1] + s1[i]
    
    for i in range(1, len(s2)):
        s2[i] = s2[i-1] + s2[i]

    print("s1 {} s2 {}".format(s1, s2))

    max_score = len(s1) + len(s2) - 2
    valid_score = False

    while not valid_score:
        for i in reversed(range(len(s1))):
            if(max_score - i) >= len(s2): 
                break
            if s1[i] + s2[max_score - i] <= sum:
                valid_score = True
                break
        if not valid_score:
            max_score -= 1
    print(max_score)
