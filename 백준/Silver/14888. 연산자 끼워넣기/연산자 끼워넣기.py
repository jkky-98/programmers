from sys import stdin
from itertools import permutations
from collections import deque

n =  int(stdin.readline())
num_lst = list(map(int, stdin.readline().split()))
operator = list(map(int, stdin.readline().split()))
# + - x /
operator_each = []
for idx, i in enumerate(operator):
    for j in range(i):
        operator_each.append(idx)

permut = permutations(operator_each, len(operator_each))

def make_form(num_lst, permut):
    q = deque(num_lst)
    first = q.popleft()
    value = first
    operator_idx = 0
    while len(q) != 0:
        operand = q.popleft()
        operator = permut[operator_idx]

        if operator == 0:
            value += operand
        if operator == 1:
            value -= operand
        if operator == 2:
            value *= operand
        if operator == 3:
            if value < 0:
                value = -(abs(value) // operand)
            else:
                value = value // operand

        operator_idx += 1
    return value

analysis = []
for i in permut:
    value = make_form(num_lst, i)
    analysis.append(value)

print(max(analysis))
print(min(analysis))

