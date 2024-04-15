from sys import stdin
from collections import deque

n, w, L = map(int, stdin.readline().split())
truck = list(map(int, stdin.readline().split()))

def next_step(deq, next_truck, L, time):
    used = False
    while not used:
        if sum(deq) + next_truck > L:
            deq.popleft()
            if sum(deq) + next_truck > L:
                deq.append(0)
                time += 1
                
            else:
                deq.append(next_truck)
                time += 1
                used = True
               
        else:
            deq.popleft()
            deq.append(next_truck)
            used = True
            time += 1
            
    return deq, used, time
    
def go_finish(deq, L, time):
    while sum(deq) > 0:
        deq.popleft()
        deq.append(0)
        time += 1
    return deq, time
    
deq = deque([0] * w)
time = 0
for t in truck:
    deq, used, time = next_step(deq, t, L, time)

deq, time = go_finish(deq, L, time)

print(time)