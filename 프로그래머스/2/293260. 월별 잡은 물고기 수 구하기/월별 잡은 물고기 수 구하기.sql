select count(*) as 'FISH_COUNT', MONTH(fi.TIME) as 'MONTH'
from FISH_INFO fi
group by MONTH(fi.TIME)
order by MONTH(fi.TIME) asc;