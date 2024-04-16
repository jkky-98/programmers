from sys import stdin
from collections import defaultdict
N, d, k, c = map(int, stdin.readline().split())

sushi = [int(stdin.readline()) for _ in range(N)]

window = [sushi[x] for x in range(k)]
sushi_dict = defaultdict(int)
sushi_dict[c] = 1

def counting(sushi_dict):
    count = len(sushi_dict)
    return count

for i in window:
    sushi_dict[i] += 1
    

max_sushi = counting(sushi_dict)

for i in range(k,N+k-1):
    end = i

    if end > N-1:
        end = (end % N)
    
    out_ = sushi[end-k]
    in_ = sushi[end]
    
    sushi_dict[out_] -= 1
    if sushi_dict[out_] == 0:
        sushi_dict.pop(out_)
    sushi_dict[in_] += 1
    max_sushi = max(max_sushi, counting(sushi_dict))

print(max_sushi)