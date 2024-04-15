from sys import stdin

rows, cols = map(int, stdin.readline().split())
start_x, start_y, direction = map(int, stdin.readline().split())

home_map = [list(map(int, stdin.readline().split())) for _ in range(rows)]

rotate = {0:3, 3:2, 2:1, 1:0}

move_direction = {
    0 : (-1,0),
    1 : (0,1),
    2 : (1,0),
    3 : (0,-1)
}

def robot_cleaning(home_map, start_x, start_y, direction):
    stop_sign = False
    robot_p = [start_x, start_y]

    while not stop_sign:

        if home_map[robot_p[0]][robot_p[1]] == 0:
            home_map[robot_p[0]][robot_p[1]] = 2
        next_lst = check_4_direction(robot_p[0], robot_p[1], home_map)
        # 주변에 청소되지 않은 곳이 있을 경우

        if len(next_lst) > 0:
            direction = rotate[direction]
            if 0 <= robot_p[0]+move_direction[direction][0] < rows and 0 <= robot_p[1]+move_direction[direction][1] < cols:
                if home_map[robot_p[0]+move_direction[direction][0]][robot_p[1]+move_direction[direction][1]] == 0:
                    robot_p = [robot_p[0]+move_direction[direction][0], robot_p[1]+move_direction[direction][1]]

        # 주변에 청소되지 않은 곳이 없을 경우
        else:
            if 0 <= robot_p[0] - move_direction[direction][0] < rows and 0 <= robot_p[1] - move_direction[direction][1] < cols:
                if home_map[robot_p[0] - move_direction[direction][0]][robot_p[1] - move_direction[direction][1]] == 0 | 2:
                    robot_p = [robot_p[0] - move_direction[direction][0], robot_p[1] - move_direction[direction][1]]

                else:
                    stop_sign = True
                    break
            else:
                stop_sign = True
                break

    return home_map


def check_4_direction(x,y,home_map):
    deltas = [(1,0),(-1,0),(0,1),(0,-1)]
    next_lst = []
    for d in deltas:
        if 0 <= x+d[0] < rows and 0 <= y+d[1] < cols:
            if home_map[x+d[0]][y+d[1]] == 0:
                next_lst.append((x+d[0], y+d[1]))
    return next_lst

after_map = robot_cleaning(home_map, start_x, start_y, direction)
count = 0
for i in range(rows):
    for j in range(cols):
        if after_map[i][j] == 2:
            count += 1

print(count)

