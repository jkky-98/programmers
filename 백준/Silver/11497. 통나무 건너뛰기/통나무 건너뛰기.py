from sys import stdin
from collections import deque

n =  int(stdin.readline())

def replace_lst(num_lst):
    num_lst.sort(reverse=True)
    max_value = num_lst[0]
    left = deque()
    right = deque()
    for i in range(len(num_lst)):
        if i == 0:
            pass
        else:
            if i % 2 == 0:
                left.appendleft(num_lst[i])
            else:
                right.append(num_lst[i])
    left.append(max_value)
    left.extend(right)
    return left

def difficulty(num_lst):
    diffy = 0
    for idx, i in enumerate(num_lst):

        if idx == len(num_lst) - 1:
            next_idx = 0
            height = abs(num_lst[next_idx] - i)
            diffy = max(diffy, height)
        else:
            next_idx = idx + 1
            height = abs(num_lst[next_idx] - i)
            diffy = max(diffy, height)
    return diffy

for i in range(n):
    length = int(stdin.readline())
    num_lst = list(map(int, stdin.readline().split()))
    num_lst_solved = replace_lst(num_lst)
    diffy = difficulty(num_lst_solved)
    print(diffy)