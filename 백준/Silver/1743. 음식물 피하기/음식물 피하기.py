from queue import Queue
from sys import stdin

row, col, n = map(int, stdin.readline().split())

map_lst = [[0] * (col) for _ in range(row)]
visited = [[0] * (col) for _ in range(row)]

for i in range(n):
    x, y = map(int, stdin.readline().split())
    x = x - 1
    y = y - 1

    map_lst[x][y] = 1


def search_tool(start_row, start_col, map_lst, visited):
    q = Queue()
    q.put((start_row, start_col))
    visited[start_row][start_col] = 1
    power = 1
    can_go = [(-1,0),(1,0),(0,-1),(0,1)]

    while not q.qsize() == 0:
        row, col = q.get()
        
        for i in can_go:
            if 0 <= row + i[0] < len(map_lst) and 0 <= col + i[1] < len(map_lst[0]):
                if visited[row + i[0]][col + i[1]] == 0 and map_lst[row + i[0]][col + i[1]]:
                    q.put((row + i[0], col + i[1]))
                    visited[row + i[0]][col + i[1]] = 1
                    power += 1
    return visited, power

power = 0
for i in range(row):
    for j in range(col):
        if map_lst[i][j] == 1 and visited[i][j] == 0:
            visited, power_new = search_tool(i, j, map_lst, visited)
            power = max(power, power_new)
            
print(power)