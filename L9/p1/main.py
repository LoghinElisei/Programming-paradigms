from Handler import *
from Command import *

def find_fileType():
    h0 = ConcreteHandler0()
    h1 = ConcreteHandler1()
    h2 = ConcreteHandler2()
    h3 = ConcreteHandler3(FallbackHandler())
    h0.succesor = h1
    h1.succesor = h2
    h2.succesor = h3
    file = input('File name = ')
    h0.handle(file)

    f = open("filetype.txt","r")
    filetype = f.read()
    match filetype:
        case "kotlin":
            return KotlinExecuteCommand("main.jar")
        case "python":
            return PythonExecuteCommand(file)
        case "bash":
            return BashExecuteCommand(file)
        case "java":
            return JavaExecuteCommand(file)
        case _:
            return None

def main():
    compilator = CommandInvoker()
    command = find_fileType()
    if command:
        compilator.set_command(command)
    else:
        print("Unknow file type")
    # compilator.set_command(JavaExecuteCommand("file3"))
    # compilator.set_command(BashExecuteCommand("file2"))
    # compilator.set_command(PythonExecuteCommand("file1"))
    # compilator.set_command()
    compilator.execute_command()

if __name__ == "__main__":
    main()