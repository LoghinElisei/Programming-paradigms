import Product
from Observable import ChoiceObserver
from Product import SelectProductSTM
from State import TakeMoneySTM


class VendingMachineSTM(ChoiceObserver):
    def __init__(self , take_money_stm , select_product_stm):
        self.take_money_stm = take_money_stm
        self.select_product_stm = select_product_stm

    def proceed_to_checkout(self):
        state = self.select_product_stm.current_state

        product_price = state.price
        # inserted_money = self.take_money_stm.money

        while ( self.take_money_stm.money < product_price):
            print(f"Product cost : {product_price} lei")
            print(f"Inserted money : {self.take_money_stm.money} lei . !!! Please insert !!! ")
            value = float(input())
            self.take_money_stm.add_money(value)


        print("-> Take the product from the box <-")
        rest = self.take_money_stm.money - product_price
        print(f"Rest : {rest} lei")

        if rest == 0:
            return
        print("Choose an option")
        print("[1] Take another product ")
        print("[2] Take the rest")
        option = int(input(">> "))

        match option:
            case 1:
                self.select_product_stm.current_state = self.select_product_stm.select_product_state
                self.take_money_stm.money = rest
                self.select_product_stm.choose_another_product()
                self.proceed_to_checkout()
            case 2:
                print(f"Returning rest : {rest}")
                self.take_money_stm.money=0
            case _:
                print("Invalid option ")
                self.take_money_stm.money=0
