from sys import stdin

n, k = map(int, stdin.readline().split())

coins = []
dp = [(k+10)]*(k+1)
dp[0] = 1
for i in range(n):
    coins.append(int(stdin.readline()))
    
coins = list(set(coins))

for coin in coins:
    for i in range(coin, k+1):
        dp[i] = min(dp[i], dp[i-coin] + 1)
if dp[k] == k + 10:
    print(-1)
else:
    print(dp[k] - 1)
