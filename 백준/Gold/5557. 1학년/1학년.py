from sys import stdin
from collections import deque

n = int(stdin.readline())
n_lst = list(map(int, stdin.readline().split()))
ans = n_lst.pop()

def new_dp_maker(dp, next_num):
    new = [0] * 21
    for idx, i in enumerate(dp):
        if i > 0:
            one = idx + next_num
            two = idx - next_num
            if 0 <= one <= 20:
                new[one] += i
            if 0 <= two <= 20:
                new[two] += i

    return new

start = n_lst[0]
dp = [0] * 21
dp[start] = 1

for idx, i in enumerate(n_lst):
    if idx == 0:
        pass
    else:
        dp = new_dp_maker(dp, i)

print(dp[ans])
    
            
        
    
        