class GenericFile:
    # def __init__(self):
    #     raise NotImplementedError("Can't instantiate GenericFile")
    def get_path(self):
        pass
    def get_freq(self):
        pass


class TextASCII(GenericFile):
    path_absolut=""
    frecvente=""
    def get_path(self):
        return self.path_absolut
    def get_freq(self):
        return self.frecvente

class XMLFile(TextASCII):
    first_tag =""
    def get_first_tag(self):
        return self.first_tag

class TextUNICODE(GenericFile):
    path_absolut=""
    frecvente=""
    def get_path(self):
        return self.path_absolut
    def get_freq(self):
        return self.frecvente

class Binary(GenericFile):
    path_absolut=""
    frecvente=""
    def get_path(self):
        return self.path_absolut
    def get_freq(self):
        return self.frecvente

class BMP(Binary):
    width=0
    height=0
    bpp=0
    def show_info(self):
        print("width = %d\nheight = %d\n"
              "bpp = %d\n"% (self.width,self.height,self.bpp))