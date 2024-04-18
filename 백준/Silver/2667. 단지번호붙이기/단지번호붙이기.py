'''
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
'''
from sys import stdin
from queue import Queue

n = int(stdin.readline())

matrix = [[]] * n
for i in range(n):
    map_data = list(str(stdin.readline()).rstrip())
    matrix[i] = list(map(int, map_data))

def BFS(matrix, count):
    target = 1
    row = -1
    col = -1
    no_changed = False
    how_many = 0
    visited = [[0]*n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if matrix[i][j] == 1:
                row = i
                col = j
                break
        if row != -1:
            break
    if row == -1 and col == -1:
        no_changed = True
        return matrix, no_changed, how_many
    dxdy = [(1,0),(-1,0),(0,1),(0,-1)]
    q = Queue()
    q.put((row, col))
    visited[row][col] = 1
    matrix[row][col] = count
    how_many += 1
    while q.qsize() != 0:
        row, col = q.get()
        for d in dxdy:
            if 0 <= row + d[0] < n and 0 <= col + d[1] < n:
                if matrix[row+d[0]][col+d[1]] == 1 and visited[row+d[0]][col+d[1]] == 0:
                    q.put((row+d[0], col+d[1]))
                    visited[row+d[0]][col+d[1]] = 1
                    matrix[row+d[0]][col+d[1]] = count
                    how_many += 1

    return matrix, no_changed, how_many

no_changed = False
count = 2
how_many_lst = []
while no_changed == False:
    matrix, no_changed, how_many = BFS(matrix, count)
    count += 1
    how_many_lst.append(how_many)

how_many_lst.pop()
how_many_lst.sort()

print(count - 3)
for i in range(count - 3):
    print(how_many_lst[i])
