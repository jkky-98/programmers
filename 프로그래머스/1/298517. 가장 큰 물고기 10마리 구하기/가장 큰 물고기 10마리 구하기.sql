select fi.ID, fi.LENGTH 
from FISH_INFO as fi
where LENGTH > 10
order by fi.LENGTH desc, fi.ID asc
limit 10

