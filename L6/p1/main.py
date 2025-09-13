import os
import GenericFile as gf
import function as fct
from typing import List
def main():
    i=1
    print("Alegeti o optiune :")
    print("1.Listare pentru Folder curent")
    print("2.Listare pentru Folder specific\n>> ",end="")
    option=int(input())

    #/home/elisei/facultate/an2/PP/pp-1210b-homeworks-EliseiLog/L6/p1/dir
    if(option == 2):
        print("Dati calea absoluta a directorului")
        ROOT_DIR=input()
        if not os.path.exists(ROOT_DIR):
            print("Directorul nu exista")
            exit("Eroare deschidere director")
    else:
        ROOT_DIR = os.path.dirname(os.path.abspath(__file__))

    fileList : List[gf.GenericFile] = []
    for root, subdirs, files in os.walk(ROOT_DIR):
        for file in os.listdir(root):
            file_path = os.path.join(root, file)
            if os.path.isfile(file_path):
                # deschide fișierul spre acces binar
                f = open(file_path, 'rb')
                try:
                    # în content se va depune o listă de octeți
                    content = f.read()
                    i=i+1
                    file = fct.getFileType(content)
                    file.path_absolut =  file_path
                    fileList.append(file)
                finally:
                    f.close()

    for file in fileList:
        print(file.get_path())

if __name__=="__main__":
    main()