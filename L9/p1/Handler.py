import abc


class Handler(metaclass=abc.ABCMeta):
    def __init__(self,succesor=None):
        self.succesor = succesor
    def handle (self,file):
        res = self.check_fileType(file)
        if not res and self.succesor:
            self.succesor.handle(file)

    @abc.abstractmethod
    def check_fileType(self,file):
        """search the type of file"""


#Kotlin
class ConcreteHandler0(Handler):
    @staticmethod
    def check_fileType(file):
        keywords = {'fun','when','data','object'}
        f = open(file,"r")
        out = open("filetype.txt","w")

        for line in f:
            if "fun main" in line:
                print("The file type is -> Kotlin <-")
                out.write("kotlin")
                return True
            ln = line.strip().split('#')[0] #remove the comment
            words = ln.split()
            if any(word in keywords for word in words):
                print("The file type is -> Kotlin <-")
                out.write("kotlin")
                return True
        f.close()
        out.close()

#Python
class ConcreteHandler1(Handler):
    def check_fileType(self,file):
        keywords = {'yield','None', 'as','with', 'lambda', 'async', '__name__'}
        f = open(file, "r")
        out = open("filetype.txt","w")
        for line in f:
            if "def main" in line:
                print("The file type is -> Python <-")
                out.write("python")
                return True
            ln = line.strip().split('#')[0]  # remove the comment
            words = ln.split()
            if any(word in keywords for word in words):
                print("The file type is -> Python <-")
                out.write("python")
                return True
        f.close()
        out.close()

#Bash
class ConcreteHandler2(Handler):
    def check_fileType(self,file):
        keywords = {'fi','esac','$?','$$','$#','$@','$*','eval','done','echo'}

        f = open(file, "r")
        out=open("filetype.txt","w")
        for line in f:
            if "#!/bin/bash" in line or "#!/bin/sh" in line:
                print("The file type is -> Bash <- ")
                out.write("bash")
                return True
            ln = line.strip().split('#')[0]  # remove the comment
            words = ln.split()
            if any(word in keywords for word in words):
                print("The file type is -> Bash <-")
                out.write("bash")
                return True
        f.close()


#Java
class ConcreteHandler3(Handler):
    def check_fileType(self,file):
        keywords = {'extends','implements','volatile','package','super'}
        f = open(file, "r")
        out = open("filetype.txt" , "w")
        for line in f:
            if "public static void main" in line:
                print("The file type is -> Java <-")
                out.write("java")
                return True
            ln = line.strip().split('#')[0]  # remove the comment
            words = ln.split()
            if any(word in keywords for word in words):
                print("The file type is -> Java <-")
                out.write("java")
                return True
        f.close()


class FallbackHandler(Handler):
    @staticmethod
    def check_fileType(file):
        print('End of chain. The file type is not among Kotlin/Python/Bash/Java ')
        return False
