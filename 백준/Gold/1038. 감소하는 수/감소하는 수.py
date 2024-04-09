from itertools import combinations
from sys import stdin
n = int(stdin.readline())

arr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

nCr = list(combinations(arr, 10))

my_lst = []
for i in range(2, 11):
    nCr = combinations(arr, i)
    for i in nCr:
        lst_tmp = []
        for j in i:
            lst_tmp.append(j)
        lst_tmp.sort(reverse=True)
        number = "".join(str(s) for s in lst_tmp)
        my_lst.append(number)
my_lst = [int(n) for n in my_lst]
for i in range(0,10):
    my_lst.append(i)
my_lst.sort()

if n > len(my_lst) - 1 :
    print(-1)
else:
    print(my_lst[n])
