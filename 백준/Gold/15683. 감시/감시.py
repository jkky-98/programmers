
from sys import stdin
import copy

rows, cols = map(int, stdin.readline().split())

matrix = [list(map(int, stdin.readline().split())) for _ in range(rows)]

hash_type = {
    1 : [0,1,2,3],
    2 : [(0,2), (1,3)],
    3 : [(0,1), (1,2), (2,3), (3,0)],
    4 : [(0,1,2), (1,2,3), (2,3,0), (3,0,1)],
    5 : [(0,1,2,3)]
}

hash_count = {
    1 : 4,
    2 : 2,
    3 : 4,
    4 : 4,
    5 : 1
}

fill = [(0,-1), (1,0), (0,1), (-1,0)]

def cctv(matrix, x, y, type_root):
    matrix_tmp = copy.deepcopy(matrix)
    type_num = matrix_tmp[x][y]
    
    type_ = hash_type[type_num]

    if type_num == 1:
        matrix_tmp = filler(matrix_tmp, x, y, type_root)
    else:
        for i in type_[type_root]:
            matrix_tmp = filler(matrix_tmp, x, y, i)
    return matrix_tmp
        
    
def filler(matrix, x, y, direction):
    dx, dy = fill[direction]
    
    while True:
        x += dx
        y += dy
        if 0 <= x < rows and 0 <= y < cols:
            if matrix[x][y] == 0:
                matrix[x][y] = 9
            elif matrix[x][y] == 6:
                break
        else:
            break
    return matrix


cctvs = []

for i in range(rows):
    for j in range(cols):
        if 1 <= matrix[i][j] <= 5:
            cctvs.append((i,j))

def check_zero(matrix):
    row = len(matrix)
    col = len(matrix[0])
    count = 0
    for r in range(row):
        for c in range(col):
            if matrix[r][c] == 0:
                count += 1
    return count

count_lst = []

def brute_force(cctvs, matrix):
    cctvs = copy.deepcopy(cctvs)
    if len(cctvs) == 0:
        count = check_zero(matrix)
        count_lst.append(count)
        return None

    cctv_item = cctvs.pop()
    x, y = cctv_item
    tmp_type = matrix[x][y]

    matrix_tmp = copy.deepcopy(matrix)

    for i in range(hash_count[tmp_type]):
        matrix = cctv(matrix_tmp, x, y, i)
        brute_force(cctvs, matrix)

cctvs.reverse()
brute_force(cctvs, matrix)
print(min(count_lst))


    