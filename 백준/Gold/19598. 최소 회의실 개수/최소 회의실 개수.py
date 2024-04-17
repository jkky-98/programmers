from sys import stdin
import heapq
n = int(stdin.readline())

plan_lst = [list(map(int, stdin.readline().split())) for _ in range(n)]
plan_lst = sorted(plan_lst, key= lambda x : x[0])

rooms = [0]

for plan in plan_lst:
    start = plan[0]
    end = plan[1]
    count = 1
    if start >= rooms[0]:
        heapq.heappop(rooms)
    heapq.heappush(rooms, end)


print(len(rooms))