from sys import stdin
from queue import Queue

col, row = map(int, stdin.readline().split())

tomato_map = [[] for _ in range(row)]

for i in range(row):
    data = list(map(int, stdin.readline().split()))
    tomato_map[i]=data


def spread_next(tomato_map, start_num):
    dxdy = [(1, 0), (-1, 0), (0, 1), (0, -1)]
    row = len(tomato_map)
    col = len(tomato_map[0])

    q = Queue()
    for i in range(row):
        for j in range(col):
            if tomato_map[i][j] == start_num:
                q.put((i, j))

    visited = [[0] * col for _ in range(row)]

    while not q.empty():
        x, y = q.get()
        for i in dxdy:
            if 0 <= x + i[0] < row and 0 <= y + i[1] < col:
                if tomato_map[x + i[0]][y + i[1]] == 0 and visited[x + i[0]][y + i[1]] == 0 and \
                        tomato_map[x + i[0]][y + i[1]] != -1:
                    tomato_map[x + i[0]][y + i[1]] = tomato_map[x][y] + 1
                    visited[x + i[0]][y + i[1]] = 1
                    q.put((x + i[0] , y + i[1]))


                elif tomato_map[x + i[0]][y + i[1]] == 0 and visited[x + i[0]][y + i[1]] != 0 and \
                        tomato_map[x + i[0]][y + i[1]] != -1:
                    tomato_map[x + i[0]][y + i[1]] = min(tomato_map[x][y] + 1, tomato_map[x + i[0]][y + i[1]])
                    q.put((x + i[0], y + i[1]))

    return tomato_map

tomato_map = spread_next(tomato_map, 1)

ripe = True
for i in tomato_map:
    if 0 in i:
        ripe = False

day = 0
for i in tomato_map:
    day = max(max(i), day)


if ripe:
    print(day-1)
else:
    print(-1)


