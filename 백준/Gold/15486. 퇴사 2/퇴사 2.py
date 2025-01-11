from sys import stdin

n = int(stdin.readline())
day_lst = []
pay_lst = []

for i in range(n):
    day, pay = map(int, stdin.readline().split())
    day_lst.append(day)
    pay_lst.append(pay)
     
dp = [0]*(n+5)

for i in range(n):
    day = day_lst[i]
    pay = pay_lst[i]
    
    index = i + day - 1
    if index < n:
        dp[index] = max(dp[index], dp[i-1] + pay)
    if dp[i] < dp[i-1]:
        dp[i] = dp[i-1]

print(max(dp))
    
    