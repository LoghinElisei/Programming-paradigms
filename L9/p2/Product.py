from Observable import Observable
from State import State

class SelectProductSTM(Observable):
    def __init__(self):
        super().__init__()
        self.select_product_state = SelectProduct(self)
        self.coca_cola_state =CocaCola(self)
        self.pepsi_state = Pepsi(self)
        self.sprite_state = Sprite(self)
        self.current_state = self.select_product_state

    def choose_another_product(self):
        self.current_state.choose()

class SelectProduct(State):
    def __init__(self,state_machine):
        self.state_machine = state_machine
        self.price = 0

    def choose(self):
        print("Choose one of the option ")
        print(" [1] Pepsi - 7 lei")
        print(" [2] CocaCola - 9 lei")
        print(" [3] Sprite - 5 lei")
        option = int(input(">> "))

        match option:
            case 1:
                self.state_machine.current_state = self.state_machine.pepsi_state
            case 2:
                self.state_machine.current_state = self.state_machine.coca_cola_state
            case 3:
                self.state_machine.current_state = self.state_machine.sprite_state
            case _:
                print("Error , invalid option")
                raise ValueError

class CocaCola(State):
    def __init__(self,state_machine):
        self.state_machine = state_machine
        self.price = 9

class Pepsi(State):
    def __init__(self, state_machine):
        self.state_machine = state_machine
        self.price = 7

class Sprite(State):
    def __init__(self, state_machine):
        self.state_machine = state_machine
        self.price = 5
