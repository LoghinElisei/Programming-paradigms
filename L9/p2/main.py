from Observable import DisplayObserver, ChoiceObserver
from Product import SelectProductSTM
from State import TakeMoneySTM
from VendingMachine import VendingMachineSTM

def main():
    take_money_stm = TakeMoneySTM()
    display_observer = DisplayObserver()
    take_money_stm.attach(display_observer)

    select_product_stm = SelectProductSTM()
    choice_observer = ChoiceObserver()
    select_product_stm.attach(choice_observer)

    vending_machine = VendingMachineSTM(take_money_stm, select_product_stm)
    take_money_stm.current_state.client_arrived()
    # take_money_stm.add_money(5)
    # take_money_stm.add_money(1)
    select_product_stm.choose_another_product()

    vending_machine.proceed_to_checkout()

if __name__ == '__main__':
    main()

