# 2 162

from queue import Queue
from sys import stdin

start, end = map(int, stdin.readline().split())
q = Queue()

# 초기화 
target = 0
q.put((start, 0))
way = 0
not_found = True
while q.qsize() != 0:
    num, way = q.get()
    target = num
    num_next_1 = num * 2
    num_next_2 = int(str(num)+str(1))
    way += 1
    if target == end:
        print(way)
        not_found = False
        break
    if num_next_1 <= end:
        q.put((num_next_1, way))
    if num_next_2 <= end:
        q.put((num_next_2, way))


print(-1) if not_found else None

    
    
    
    