from sys import stdin

n = int(stdin.readline())
tower_lst = list(map(int, stdin.readline().split()))
tower_lst_rev = [x for x in tower_lst[::-1]]
tower_recieve = [0] * n
stack = []
for idx, i in enumerate(tower_lst_rev):
    if idx == 0:
        stack.append((i, idx))
    else:
        while True:
            if len(stack) > 0:
                if i >= stack[-1][0]:
                    pop_item = stack.pop()
                    tower_recieve[pop_item[1]] = idx

                else:
                    stack.append((i,idx))
                    break
            else:
                stack.append((i, idx))
                break

back = [-(x - n) for x in tower_recieve[::-1]]

for i in back:
    if i == n:
        print(0, end=" ")
    else:
        print(i, end=" ")


