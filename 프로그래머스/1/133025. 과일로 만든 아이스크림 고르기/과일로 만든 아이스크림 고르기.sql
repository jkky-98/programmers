-- 코드를 입력하세요
SELECT fh.FLAVOR
from FIRST_HALF as fh
left join ICECREAM_INFO as ii on ii.FLAVOR = fh.FLAVOR
where INGREDIENT_TYPE = 'fruit_based' and TOTAL_ORDER > 3000