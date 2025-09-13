import os
import sys
from PyQt5.QtWidgets import QWidget, QApplication, QFileDialog, QMessageBox, QLineEdit, QLabel, QVBoxLayout, \
    QTextBrowser
from PyQt5.uic import loadUi
from PyQt5 import QtCore
from multiprocessing import Process,Queue
from collections import deque
import sysv_ipc

def debug_trace(ui=None):
    from pdb import set_trace
    QtCore.pyqtRemoveInputHook()
    set_trace()
    # QtCore.pyqtRestoreInputHook()


class HTMLConverter(QWidget):
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))

    def __init__(self):
        super(HTMLConverter, self).__init__()
        ui_path = os.path.join(self.ROOT_DIR, 'html_converter.ui')
        loadUi(ui_path, self)
        self.browse_btn.clicked.connect(self.browse)
        self.file_path = None
        self.queue = Queue()

        # self.queue.put(deque([]))
        self.SendToC.clicked.connect(self.start_process_sendToC)
        self.ConvertToHTML.clicked.connect(self.start_process_html)


    def browse(self):
        options = QFileDialog.Options()
        options |= QFileDialog.DontUseNativeDialog
        file, _ = QFileDialog.getOpenFileName(self,
                                              caption='Select file',
                                              directory='',
                                              filter="Text Files (*.txt)",
                                              options=options)
        if file:
            self.file_path = file
            self.path_line_edit.setText(file)
            print(file)
    @staticmethod
    def process_html(file,queue):
        title = ""
        body = ""
        result = ""
        if file is not None:
            with (open(file,"r") as f):
                lines = f.readlines()
                if lines:
                    title = lines[0].strip()
                    body = "".join(f"\t<p>{line.strip()}</p>\n" for line in lines[2:])
                    result =("<!DOCTYPE html>\n<html>\n\t<head>\n\t\t<p>"
                            +title+"</p>\n\t</head>\n<body>\n"+"\t\t<h1>"+title+"</h1>\n" + body + "</body>\n</html>")

                    print(result)
                else:
                    result = "No content"
        else:
            result="No text document specified"
        queue.put(result)
        # lines in contents.readlines(): \
        #     e.write("<pre>" + lines + "</pre> <br>\n")
    def start_process_html(self):
        process = Process(target=self.process_html,args=(self.file_path,self.queue))
        process.start()
        process.join()

        if not self.queue.empty():

            result = self.queue.get()
            print(result)
            # if isinstance(result,deque):
            #     result =''.join(result)
            self.box.setHtml(result)
        print(type(self.box))

    def start_process_sendToC(self):
        try:
            self.message_queue = sysv_ipc.MessageQueue(-1)
            message = self.box.toPlainText()
            self.message_queue.send(message)
        except sysv_ipc.ExistentialError:
            print("Please run the C program")

if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = HTMLConverter()
    window.show()
    sys.exit(app.exec_())
