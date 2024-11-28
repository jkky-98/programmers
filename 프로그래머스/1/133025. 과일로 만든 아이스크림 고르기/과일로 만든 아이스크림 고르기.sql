-- 코드를 입력하세요
SELECT ii.FLAVOR
from ICECREAM_INFO as ii, FIRST_HALF as fh
where fh.TOTAL_ORDER > 3000 and ii.INGREDIENT_TYPE = 'fruit_based'
