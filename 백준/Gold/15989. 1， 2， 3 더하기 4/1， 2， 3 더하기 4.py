from sys import stdin

n = int(stdin.readline())

def count(num):
    dp = [0] * (num + 1)
    dp[0] = 1

    for i in range(1, 4):
        for j in range(i, num + 1):
            dp[j] += dp[j - i]

    return dp[-1]

for i in range(n):
    num = int(stdin.readline())
    print(count(num))