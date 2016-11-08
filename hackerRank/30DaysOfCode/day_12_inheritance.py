class Person:
	def __init__(self, firstName, lastName, idNumber):
		self.firstName = firstName
		self.lastName = lastName
		self.idNumber = idNumber
	def printPerson(self):
		print("Name:", self.lastName + ",", self.firstName)
		print("ID:", self.idNumber)

class Student(Person):
    def __init__(self, firstName, lastName, idNumber, scores):
        super().__init__(firstName, lastName, idNumber)
        self.scores = scores

    def calculate(self):
        total = 0
        for x in self.scores:
            total += x
        avg = total / len(scores)
        if(avg >= 90):
            return 'O'
        if(avg >= 80):
            return 'E'
        if(avg >= 70):
            return 'A'
        if(avg >= 55):
            return 'P'
        if(avg >= 40):
            return 'D'
        return 'T'
