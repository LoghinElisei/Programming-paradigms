
class Observable:
    def __init__(self):
        self.observers=[]

    def attach(self,observer):
        if observer not in self.observers:
            self.observers.append(observer)

    def dettach(self,observer):
        if observer in self.observers:
            self.observers.remove(observer)

    def notifyAll(self):
        for observer in self.observers:
            observer.update(self)


class DisplayObserver:
    def update(self,money : int):
        """print(f"Money update : {money}")"""


class ChoiceObserver:
    def update(self):
        print("A choice has been made")

