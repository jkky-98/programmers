'''
3 4 5
3 2
2 2
3 1
2 3
1 1
'''
row, col, n = map(int, input().split())

map_lst = [[0] * (col) for _ in range(row)]
visited = [[0] * (col) for _ in range(row)]

for i in range(n):
    x, y = map(int, input().split())
    x = x - 1
    y = y - 1

    map_lst[x][y] = 1

from queue import Queue

def search_tool(start_row, start_col, map_lst, visited):
    q = Queue()
    q.put((start_row, start_col))
    visited[start_row][start_col] = 1
    power = 1

    while not q.qsize() == 0:
        row, col = q.get()

        if 0 <= row - 1 < len(map_lst):
            if visited[row - 1][col] == 0 and map_lst[row - 1][col] == 1:
                q.put((row - 1, col))
                visited[row - 1][col] = 1
                power += 1
        if 0 <= row + 1 < len(map_lst):
            if visited[row + 1][col] == 0 and map_lst[row + 1][col] == 1:
                q.put((row + 1, col))
                visited[row + 1][col] = 1
                power += 1
        if 0 <= col - 1 < len(map_lst[0]):
            if visited[row][col - 1] == 0 and map_lst[row][col - 1] == 1:
                q.put((row, col - 1))
                visited[row][col - 1] = 1
                power += 1
        if 0 <= col + 1 < len(map_lst[0]):
            if visited[row][col + 1] == 0 and map_lst[row][col + 1] == 1:
                q.put((row, col + 1))
                visited[row][col + 1] = 1
                power += 1
    
    return visited, power

power = 0
for i in range(row):
    for j in range(col):
        if map_lst[i][j] == 1 and visited[i][j] == 0:
            visited, power_new = search_tool(i, j, map_lst, visited)
            power = max(power, power_new)
            
print(power)