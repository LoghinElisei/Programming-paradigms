import multiprocessing
import subprocess

def set_command(pipe,commands):
    pipe_iesire,_ = pipe
    for command in commands:
        pipe_iesire.send(command.strip())
    pipe_iesire.close()

def run_command(pipe1,pipe2):
    close , pipe_intrare = pipe1
    close.close()
    pipe_iesire,_= pipe2
    try:
        while True:
            command = pipe_intrare.recv()
            print(f"Am primit in pipe1 comanda [ ${command} ]")
            result = subprocess.run(command,shell=True,capture_output=True,text=True)
            pipe_iesire.send(result.stdout)
            print(f"Am trimis in pipe2 ->\n${result.stdout}")
    except EOFError:
        pipe_iesire.close()

if __name__ == '__main__':
    command = input("$ ")
    commands = command.split('|')
    print(commands)

    pipe1 = multiprocessing.Pipe(True)
    process_pipe1 = multiprocessing.Process(
        target = set_command ,args=(pipe1,commands))
    process_pipe1.start()
    pipe1[0].close()

    pipe2 = multiprocessing.Pipe(True)
    process_pipe2 = multiprocessing.Process(
        target = run_command ,args=(pipe1,pipe2)
    )

    process_pipe2.start()
    pipe1[0].close()
    pipe2[0].close()
    try:
        while True:
            print('Am scos elementul: ',pipe2[1].recv())
    except EOFError:
        print("End")

    process_pipe1.join()
    process_pipe2.join()