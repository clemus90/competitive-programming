class Person:
    def __init__(self, initial_age):
        if(initial_age < 0):
            print("Age is not valid, setting age to 0.")
            self.age = 0
        else:
            self.age = initial_age

    def yearPasses(self):
        self.age += 1

    def amIOld(self):
        if self.age >= 18:
            print("You are old.")
        elif self.age >= 13:
            print("You are a teenager.")
        else:
            print("You are young.")
