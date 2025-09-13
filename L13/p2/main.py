import more_itertools
from more_itertools.more import map_reduce


def main():
    print(1)
    data = 'This sentence has words of various lengths in it, both short ones and long ones ss'.lower().split()

    key_func = lambda x: x[0]
    value_func = lambda x: x
    reduce_func = lambda  words: sorted(words)
    vals = (map_reduce(data,key_func,value_func,reduce_func))

    for letter,word in sorted(vals.items()):
        print(letter,word)

if __name__ == '__main__':
    main()