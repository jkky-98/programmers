-- 코드를 입력하세요
SELECT p.PRICE as MAX_PRICE
from PRODUCT as p
order by p.PRICE DESC
limit 1