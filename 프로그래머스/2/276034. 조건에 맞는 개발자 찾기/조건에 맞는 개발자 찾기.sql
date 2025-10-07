-- 코드를 작성해주세요
select distinct d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
from developers d
join skillcodes s on d.SKILL_CODE & s.code = s.code
where s.NAME = 'Python' or s.NAME = 'C#'
order by d.ID ASC