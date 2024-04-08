from sys import stdin

n, k = map(int, stdin.readline().split())

coins = []
dp = [0]*(k+1)
dp[0] = 1
for i in range(n):
    coins.append(int(stdin.readline()))

for coin in coins:
    for i in range(coin, k+1):
        dp[i] = dp[i] + dp[i-coin]

print(dp[k])
        
    