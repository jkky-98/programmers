from sys import stdin
import heapq

n = int(stdin.readline())
heap = []

for _ in range(n):
    order = int(stdin.readline())
    if order == 0:
        if len(heap) == 0:
            print(0)
        else:
            value = heapq.heappop(heap)
            print(value)

    else:
        heapq.heappush(heap, order)

