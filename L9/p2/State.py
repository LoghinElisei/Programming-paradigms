from Observable import Observable
class State(object):
    def insert_money(self,state_machine,value):
        """:-)"""
    def client_arrived(self):
        """"""

class TakeMoneySTM(Observable):
    def __init__(self):
        super().__init__()
        self.wait_state = WaitingForClient(self)
        self.insert_money_state = InsertMoney(self)
        self.current_state=self.wait_state   #State()
        self.money = 0

    def add_money(self,value : float):
        self.current_state.insert_money(self,value)
        # self.notifyAll(self.money)

    def update_amount_of_money(self,value: float):
        self.money += value
        self.notifyAll()


class WaitingForClient(State):
    def __init__(self,state_machine ):
        self.state_machine = state_machine

    def client_arrived(self):
        print("Client arrived")
        self.state_machine.current_state=self.state_machine.insert_money_state


class InsertMoney(State):
    def __init__(self, state_machine : TakeMoneySTM):
        self.state_machine = state_machine

    def insert_money(self,state_machine,value):
        self.state_machine.update_amount_of_money(value)
        self.state_machine.notifyAll()
    # def insert_10bani(self):
    #     self.state_machine.update_amount_of_money(0.1)
    #     self.state_machine.add_money(0.1)
    #
    #
    # def insert_50bani(self):
    #     self.state_machine.update_amount_of_money(0.5)
    #     self.state_machine.add_money(0.5)
    #
    # def insert_1leu(self):
    #     self.state_machine.update_amount_of_money(1)
    #     self.state_machine.add_money(1)
    #
    # def insert_5lei(self):
    #     self.state_machine.update_amount_of_money(5)
    #     self.state_machine.add_money(5)
    #
    # def insert_10lei(self):
    #     self.state_machine.update_amount_of_money(10)
    #     self.state_machine.add_money(10)


