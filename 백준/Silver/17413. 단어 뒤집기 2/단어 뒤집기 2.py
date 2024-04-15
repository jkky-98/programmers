data = str(input())

stack = []
stack_tmp = []
full = []
for idx, i in enumerate(data):
    if i == "<":
        stack.append("<")
        if len(stack_tmp) > 0:
            stack_tmp.reverse()
            str_data = "".join(stack_tmp)
            stack_tmp = []
            full.append(str_data)
        full.append(i)
    if i == ">":
        stack.pop()
        full.append(i)

    if len(stack) == 0 and i != " " and i not in ("<", ">"):
        stack_tmp.append(i)
    if len(stack) == 0 and i == " " and i not in ("<", ">"):
        stack_tmp.reverse()
        str_data = "".join(stack_tmp)
        stack_tmp = []
        full.append(str_data)
        full.append(" ")

    if len(stack) > 0 and i not in ("<", ">"):
        full.append(i)

if len(stack_tmp) > 0:
    stack_tmp.reverse()
    str_data = "".join(stack_tmp)
    stack_tmp = []
    full.append(str_data)

print("".join(full))
