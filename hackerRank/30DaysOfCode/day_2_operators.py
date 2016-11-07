meal_cost = float(input())
tip_percent = int(input())
tax_percent = int(input())

print ("The total meal cost is {0} dollars.".format(int((meal_cost * (100 + tip_percent + tax_percent) / 100) + 0.5)))
