-- 코드를 작성해주세요
select c.ID, c.GENOTYPE, p.GENOTYPE AS PARENT_GENOTYPE
from ECOLI_DATA c
join ECOLI_DATA p on p.ID = c.PARENT_ID
where p.GENOTYPE & c.GENOTYPE = p.GENOTYPE
order by c.ID ASC;