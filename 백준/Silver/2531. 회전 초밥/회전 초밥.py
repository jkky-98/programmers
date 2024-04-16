

from sys import stdin

N, d, k, c = map(int, stdin.readline().split())

sushi = [int(stdin.readline()) for _ in range(N)]

def two_part(front, k, N):
    first_start = front
    first_end = N - 1

    second_start = 0
    second_end = k - ((N - 1) - front) - 2

    return first_start, first_end, second_start, second_end

def analysis(sushi_lst, c):
    unique = len(list(set(sushi_lst)))
    if c not in sushi_lst:
        unique += 1
    return unique
    
max_sushi = 0
for i in range(N):
    front = i
    end = i + k - 1
    if end >= N:
        fs, fe, ss, se = two_part(front, k, N)
        f_sushi = sushi[fs:fe+1]
        s_sushi = sushi[ss:se+1]
        f_sushi.extend(s_sushi)
        sushi_tmp = f_sushi
    
    else:
        sushi_tmp = sushi[front:end+1]

    how_many_sushi = analysis(sushi_tmp, c)
    max_sushi = max(max_sushi, how_many_sushi)

print(max_sushi)

    
    