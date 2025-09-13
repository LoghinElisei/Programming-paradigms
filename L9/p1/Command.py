import abc
import subprocess

class Command(metaclass=abc.ABCMeta):
    @abc.abstractmethod
    def execute(self):
        pass


class KotlinExecuteCommand(Command):
    def __init__(self,file):
        self.file = file

    def execute(self):
        try:
            result = subprocess.run(['kotlin',self.file],capture_output=True,text=True)
            if result.returncode == 0 :
                return result.stdout
            else:
                print(f"Execution failed : {result.stderr}")
                return 0
        except Exception as e:
            print("Couldn't execute Kotlin file")
            return 0

class PythonExecuteCommand(Command):
    def __init__(self,file):
        self.file = file

    def execute(self):
        try:
            result = subprocess.run(['python',self.file],capture_output=True,text=True)
            return result.stdout
        except Exception as e:
            print("Couldn't execute Python file")
            return 0

class BashExecuteCommand(Command):
    def __init__(self,file):
        self.file = file

    def execute(self):
        try:
            result = subprocess.run(['bash',self.file],capture_output=True,text=True)
            return result.stdout
        except Exception as e:
            print("Couldn't execute Bash file")
            return 0

class JavaExecuteCommand(Command):
    def __init__(self,file):
        self.file = file

    def execute(self):
        try:
            result = subprocess.run(['java',self.file],capture_output=True,text=True)
            if result.returncode == 0:
                return result.stdout
            else:
                print(f"Execution failed: {result.stderr}")
                return 0
        except Exception as e:
            print("Couldn't execute Java file")
            return str(e)


class CommandInvoker:
    def __init__(self):
        self.command = None

    def set_command(self, command : Command):
        self.command = command

    def execute_command(self):
        if(self.command):
            print(self.command.execute())
        else:
            print("Exit")
