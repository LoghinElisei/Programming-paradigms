import functools
import more_itertools
def main():


    list_numbers = [1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8]
    greater_than_5 = list(filter(lambda x: x > 5, list_numbers))


    # pair = more_itertools.pairwise(greater_than_5)
    pair = zip(greater_than_5[::2], greater_than_5[1::2])
    # for i in pair:
    #     print(i)

    multiplied = map(lambda x: x[0] * x[1], pair)

    sum = functools.reduce(lambda x, y: x + y, multiplied)
    # for i in multiplied:
    #     print(i)

    print(sum)

if __name__ == '__main__':
  main()
