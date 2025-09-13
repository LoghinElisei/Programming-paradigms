import os
import tkinter as tk
from multiprocessing import Process,Queue
from collections import deque

class Parser:
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))


    def __init__(self, gui):
        self.gui = gui
        self.gui.title('List Computer')
        self.gui.geometry("1500x500")
        #queue init
        self.queue = Queue()
        self.queue.put(deque([]))


        self.integer_list_lbl = tk.Label(master=self.gui,
                                         text="List of integers:")
        self.add_list_btn = tk.Button(master=self.gui,
                                      text="Add list",
                                      command=self.add_list)
        self.filter_odd = tk.Button(master=self.gui,
                                      text="Filter odd",
                                      command=self.start_process_odd)
        self.filter_primes = tk.Button(master=self.gui,
                                    text="Filter primes",
                                    command=self.start_process_primes)
        self.sum = tk.Button(master=self.gui,
                                       text="Sum",
                                       command=self.start_process_sum)

        self.integer_list_text = tk.Text(self.gui, width=50, height=1)
        self.integer_list_text.insert(tk.END, str(list(range(1, 16)))[1:-1])
        # alignment on the grid
        self.integer_list_lbl.grid(row=0, column=0)
        # self.todo0_lbl.grid(row=1, column=1)
        # self.todo1_lbl.grid(row=2, column=1)
        self.integer_list_text.grid(row=0, column=1)
        self.add_list_btn.grid(row=0, column=3)
        self.filter_odd.grid(row=2,column=3)
        self.filter_primes.grid(row=3,column=3)
        self.sum.grid(row=4,column=3)

        self.result = tk.Label(master=self.gui,text="Result:")
        self.result = tk.Label(master=self.gui,text=self.queue.get())
        self.result = tk.Text(self.gui, width=50, height=10)
        self.result.insert(tk.END, "Result\n")
        self.result.grid(row=2, column=1)

        self.gui.mainloop()

    def add_list(self):
        result = self.integer_list_text.get("1.0", tk.END)
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        self.integer_list = result
        print(result)

    @staticmethod # because the function doesn't require self
    def filter_odd_process(list , queue):
        odd = [i for i in list if i%2 == 1]
        queue.put(odd)
        print(odd)
    def start_process_odd(self):
        processOdd = Process(target=self.filter_odd_process, args=(self.integer_list,self.queue,))
        processOdd.start()
        processOdd.join()
        if not self.queue.empty():
            self.result.insert(tk.END,"Odd Numbers : ")
            self.result.insert(tk.END,self.queue.get())
            self.result.insert(tk.END,"\n")

    @staticmethod
    def filter_primes_process(list,queue):
        primes = []
        for num in list:
            ok=True
            for i in range(2,num):
                if num % i ==0:
                    ok=False
                    break
            if(ok == True):
                primes.append(num)

        queue.put(primes)
    def start_process_primes(self):
        process_primes = Process(target=self.filter_primes_process, args=(self.integer_list,self.queue,))
        process_primes.start()
        process_primes.join()
        if not self.queue.empty():
            self.result.insert(tk.END,"Primes Numbers : ")
            self.result.insert(tk.END,self.queue.get())
            self.result.insert(tk.END,"\n")

    @staticmethod
    def sum_process(list, queue):
        result = sum(list)
        queue.put(result)

    def start_process_sum(self):
        process_sum = Process(target=self.sum_process, args=(self.integer_list, self.queue,))
        process_sum.start()
        process_sum.join()
        if not self.queue.empty():
            self.result.insert(tk.END, "Sum : ")
            self.result.insert(tk.END, self.queue.get())
            self.result.insert(tk.END, "\n")

if __name__ == '__main__':
    root = tk.Tk()
    root.title('List Computer')
    app = Parser(root)
    root.mainloop()