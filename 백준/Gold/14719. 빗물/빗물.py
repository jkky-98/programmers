from sys import stdin
from collections import deque
row, col = map(int, stdin.readline().split())
block = list(map(int, stdin.readline().split()))

my_map = []

for i in block:
    deq_tmp = deque()
    for j in range(i):
        deq_tmp.append(1)
    for j in range(row-i):
        deq_tmp.appendleft(0)
    my_map.append(list(deq_tmp))
my_map = [list(x) for x in zip(*my_map)]

def water(my_lst):
    my_que = deque(my_lst)
    cand = deque()
    signal = False
    for idx in range(len(my_que)):
        pop_ = my_que.popleft()
        if pop_ == 1 and signal == False:
            signal = True

        if pop_ == 1 and signal == True and len(cand) > 0:
            for i in range(len(cand)):
                idx_water = cand.popleft()
                my_lst[idx_water] = "w"

        if pop_ == 0 and signal == True:
            cand.append((idx))

    return my_lst

for idx, i in enumerate(my_map):
    my_map[idx] = water(i)

count = 0
for i in range(row):
    for j in range(col):
        if my_map[i][j] == "w":
            count += 1

print(count)





