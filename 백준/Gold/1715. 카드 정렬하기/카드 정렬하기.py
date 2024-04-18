from sys import stdin
import heapq

n = int(stdin.readline())

card = [int(stdin.readline()) for _ in range(n)]

card.sort()

def loof(card):
    count = 0
    if len(card) == 1:
        return count
    while len(card) != 0:
        first = heapq.heappop(card)
        try:
            second = heapq.heappop(card)
        except:
            second = 0
        heapq.heappush(card, first+second)
        if len(card) == 1:
            count += first + second
            break
        if second != 0:
            count += first + second
    return count
        
count_full = 0
count = loof(card)
print(count)

