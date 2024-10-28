select di.ID, di.EMAIL, di.FIRST_NAME, di.LAST_NAME
from DEVELOPER_INFOS di
where di.SKILL_1 = 'Python'
or di.SKILL_2 = 'Python'
or di.SKILL_3 = 'Python'
order by di.ID asc