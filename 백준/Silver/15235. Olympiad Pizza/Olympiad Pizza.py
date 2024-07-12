from sys import stdin
from queue import Queue

n = int(stdin.readline())

par_lst = list(map(int, stdin.readline().split()))
# init #

q = Queue()
for idx, i in enumerate(par_lst):

    q.put((idx, i))

time_lst = [0]*n

time = 0
while not q.empty():
    idx, pizza_needed = q.get()
    time += 1
    if pizza_needed == 1:
        time_lst[idx] = time
    else:
        q.put((idx, pizza_needed-1))

for i in range(n):
    print(time_lst[i], end=' ')