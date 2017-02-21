def getProgrammersDay(year):
    daysOfTheMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    daysOfTheMonthLeap = [x for x in daysOfTheMonth]
    daysOfTheMonthLeap[1] = 29
    daysOfTheMonth18 = [x for x in daysOfTheMonth]
    daysOfTheMonth18[1] = 28 - 13

    setToUse = []
    if year == 1918:
        setToUse = daysOfTheMonth18
    elif year < 1918:
        if year % 4 == 0:
            setToUse = daysOfTheMonthLeap
        else:
            setToUse = daysOfTheMonth
    else:
        if year % 400 == 0 or (year % 4 == 0 and year % 100 != 0):
            setToUse = daysOfTheMonthLeap
        else:
            setToUse = daysOfTheMonth
    
    day = 256
    month = -1
    remaining = -1
    for m in range(12):
        if day - setToUse[m] > 0:
            day -= setToUse[m]
        else:
            month = m
            remaining = day
            break
    return month+1,remaining

year = int(input())

month, day = getProgrammersDay(year)
print("{0:02d}.{1:02d}.{2}".format(day,month,year))

