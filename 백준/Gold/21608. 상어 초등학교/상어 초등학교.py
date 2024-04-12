from sys import stdin


n = int(stdin.readline())
student_hash = [[] for _ in range(n**2 + 1)]
student_call = []
for i in range(n**2):
    student = list(map(int, stdin.readline().split()))
    student_idx = student[0]
    student_like = student[1:]

    student_hash[student_idx] = student_like
    student_call.append(student_idx)

class_room = [[0]*n for _ in range(n)]

# 모든 위치에 대해 인접한 칸에 몇 명의 친구가 존재하는지 리턴한다.
def search_like(student_idx, class_room):
    length = len(class_room)
    like = student_hash[student_idx]
    like_student_map = [[0]*length for _ in range(length)]
    
    dxdy = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    for i in range(length):
        for j in range(length):
            if class_room[i][j] == 0:
                for k in dxdy:
                    if 0 <= i + k[0] < length and 0 <= j + k[1] < length:
                        if class_room[i + k[0]][j + k[1]] in like:
                            like_student_map[i][j] += 1
    
    # 최댓값들을 가지는 위치를 리스트로 리턴한다.
    max_like = max(map(max, like_student_map))
    if max_like == 0:
        return []
    max_like_student = []
    for i in range(length):
        for j in range(length):
            if like_student_map[i][j] == max_like:
                max_like_student.append((i, j))
    
    return max_like_student

def optimal_positioner(class_room, max_like_student):
    dxdy = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    length = len(class_room)
    empty_space = [[0]*length for _ in range(length)]

    if len(max_like_student) == 0:
        for i in range(length):
            for j in range(length):
                if class_room[i][j] == 0:
                    for k in dxdy:
                        if 0 <= i + k[0] < length and 0 <= j + k[1] < length:
                            if class_room[i + k[0]][j + k[1]] == 0:
                                empty_space[i][j] += 1
        
        # max
        max_empty = max(map(max, empty_space))
        max_empty_student = []
        for i in range(length):
            for j in range(length):
                if empty_space[i][j] == max_empty:
                    max_empty_student.append((i, j))
        # sort
        max_empty_student.sort(key=lambda x: (x[0], x[1]))
        if max_empty == 0:
            for i in max_empty_student:
                if class_room[i[0]][i[1]] == 0:
                    return i
        return max_empty_student[0]

    else:
        if len(max_like_student) == 1:
            return max_like_student[0]
        else:
            hash_map_tmp = [0]*len(max_like_student)
            for idx, i in enumerate(max_like_student):
                # (1,0)
                row, col = i
                for k in dxdy:
                    if 0 <= row + k[0] < length and 0 <= col + k[1] < length:
                        if class_room[row + k[0]][col + k[1]] == 0:
                            hash_map_tmp[idx] += 1

            max_empty = max(hash_map_tmp)
            max_empty_student = []

            for idx, i in enumerate(max_like_student):
                if hash_map_tmp[idx] == max_empty:
                    max_empty_student.append((i[0], i[1]))

            # 정렬
            max_empty_student.sort(key=lambda x: (x[0], x[1]))
            
            return max_empty_student[0]

def satisfaction_calculater(class_room):
    length = len(class_room)
    map_satisfaction = [[0]*length for _ in range(length)]
    
    dxdy = [(0, 1), (0, -1), (1, 0), (-1, 0)]
    for i in range(length):
        for j in range(length):
            like = student_hash[class_room[i][j]]
            for k in dxdy:
                if 0 <= i + k[0] < length and 0 <= j + k[1] < length:
                    if class_room[i + k[0]][j + k[1]] in like:
                        map_satisfaction[i][j] += 1
    satisfaction = 0
    for i in range(length):
        for j in range(length):
            like_n = map_satisfaction[i][j]
            satisfaction += int(10**(like_n-1))
    return satisfaction

for i in student_call:
    student_idx = i
    max_like_student = search_like(student_idx, class_room)
    optimal_position = optimal_positioner(class_room, max_like_student)
    class_room[optimal_position[0]][optimal_position[1]] = student_idx


# 만족도 계산
score =  satisfaction_calculater(class_room)

print(score)