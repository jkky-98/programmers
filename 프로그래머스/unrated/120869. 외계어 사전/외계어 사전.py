spell= ['z','x','d']
dic = ['udxd','zxd','dxia']

def solution(spell, dic):
    spell_bool = [False]*len(spell)
    for index, i in enumerate(dic):
        sen = i
        for j in spell:
            if j in list(sen):
                spell_bool[spell.index(j)] = True
                sen = sen.replace(j,'',-1)

        if sum(spell_bool) == len(spell) and len(sen)==0:
            return 1
        else:
            spell_bool = [False]*len(spell)
    return 2
