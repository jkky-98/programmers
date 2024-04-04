from sys import stdin
from queue import Queue
col, row = map(int, stdin.readline().split())

field = [[] for _ in range(row)]
field_visited = [[0]*col for _ in range(row)]

for i in range(row):
    field[i] = list(str(stdin.readline()))
    
def linked(start_row, start_col, field_visited, field):
    can_go_que = Queue()
    color = field[start_row][start_col]
    field_visited_set = field_visited.copy()
    
    row = start_row
    col = start_col
    can_go_que.put((row, col))
    field_visited_set[row][col] = 1
    count = 1
    while can_go_que.qsize() != 0:
        row, col = can_go_que.get()
        
        if 0 <= row - 1 < (len(field)): 
            if field[row-1][col] == color and field_visited_set[row-1][col] == 0:
                can_go_que.put((row-1, col))
                field_visited_set[row-1][col] = 1
                count += 1
        if 0 <= row + 1 < (len(field)): 
            if field[row+1][col] == color and field_visited_set[row+1][col] == 0:
                can_go_que.put((row+1, col))
                field_visited_set[row+1][col] = 1
                count += 1
        if 0 <= (col-1) < (len(field[0])): 
            if field[row][col-1] == color and field_visited_set[row][col-1] == 0:
                can_go_que.put((row, col-1))
                field_visited_set[row][col-1] = 1
                count += 1
        if 0 <= (col+1) < (len(field[0])): 
            if field[row][col+1] == color and field_visited_set[row][col+1] == 0:
                can_go_que.put((row, col+1))
                field_visited_set[row][col+1] = 1
                count += 1

    # 리스트안의 요소들 모두 합
    count_sum = count

    if count_sum == 1:
        count_sum = 1
    if count_sum >= 2:
        count_sum = count_sum ** 2
    
    return field_visited_set, count_sum, color
        
power_map = {"W": 0, "B": 0}
for i in range(row):
    for j in range(col):
        if field_visited[i][j] == 0:
            field_visited, count_sum, color = linked(i, j, field_visited, field)
            power_map[color] += count_sum
            count_sum = 0

            
print(power_map["W"], power_map["B"])
            
    
    
    
                