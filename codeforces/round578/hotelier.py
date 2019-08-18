# codeforces round 578 - A - Hotelier
def cleanHotel():
    return [0] * 10


def main():
    eventCount = int(input())
    events = input()
    leftRoom = 0
    rightRoom = 9
    hotel = cleanHotel()
    for event in events:
        
        if event == "L":
            hotel[leftRoom] = 1
            for i in range(leftRoom + 1, 10):
                if hotel[i] == 0:
                    leftRoom = i
                    break
        elif event == "R":
            hotel[rightRoom] = 1
            for i in range(rightRoom - 1, -1, -1):
                if hotel[i] == 0:
                    rightRoom = i
                    break
        else:
            roomLeaving = int(event)
            hotel[roomLeaving] = 0
            if roomLeaving < leftRoom:
                leftRoom = roomLeaving
            if roomLeaving > rightRoom:
                rightRoom = roomLeaving
    print(''.join([str(r) for r in hotel]))


main()