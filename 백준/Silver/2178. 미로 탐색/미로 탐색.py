from sys import stdin
from queue import Queue
row_, col_ = map(int, stdin.readline().split())

my_map = [[] for _ in range(row_)]
my_visited = [[0]*col_ for _ in range(row_)]

for i in range(row_):
    m_row = str(stdin.readline().strip())
    for j in m_row:
        num = int(j)
        my_map[i].append(num)
        
def solution(my_map, my_visited):
    row = 0
    col = 0
    planner = Queue()
    # 초기화
    planner.put((row, col))
    
    while not planner.empty():
        row, col = planner.get()
        if 0 <= row + 1 < row_:
            if my_map[row+1][col] > 0 and my_visited[row+1][col] < 1:
                my_visited[row+1][col] = my_visited[row][col] + 1
                planner.put((row+1, col))
                
        if 0 <= row - 1 < row_:
            if my_map[row-1][col] > 0 and my_visited[row-1][col] < 1:
                my_visited[row-1][col] = my_visited[row][col] + 1
                planner.put((row-1, col))
            
        if 0 <= col + 1 < col_:
            if my_map[row][col+1] > 0 and my_visited[row][col+1] < 1:
                my_visited[row][col+1] = my_visited[row][col] + 1
                planner.put((row, col+1))
                
        if 0 <= col - 1 < row_:
            if my_map[row][col-1] > 0 and my_visited[row][col-1] < 1:
                my_visited[row][col-1] = my_visited[row][col] + 1
                planner.put((row, col-1))  
                
    print(my_visited[row_ - 1][col_ - 1] + 1)

solution(my_map, my_visited)
    
