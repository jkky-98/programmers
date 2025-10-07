select YEAR(e.DIFFERENTIATION_DATE) as 'YEAR', (
    select max(size_of_colony)
from ECOLI_DATA e2
where YEAR(e2.DIFFERENTIATION_DATE) = YEAR(e.DIFFERENTIATION_DATE)
group by YEAR(e2.DIFFERENTIATION_DATE)
) - e.size_of_colony as 'YEAR_DEV', e.ID as 'ID'
from ECOLI_DATA e
order by YEAR(e.DIFFERENTIATION_DATE) ASC, (
    select max(size_of_colony)
from ECOLI_DATA e2
where YEAR(e2.DIFFERENTIATION_DATE) = YEAR(e.DIFFERENTIATION_DATE)
group by YEAR(e2.DIFFERENTIATION_DATE)
) - e.size_of_colony ASC;