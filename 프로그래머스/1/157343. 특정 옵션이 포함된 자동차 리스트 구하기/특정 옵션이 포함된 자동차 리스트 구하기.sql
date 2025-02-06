-- 코드를 입력하세요
SELECT *
from CAR_RENTAL_COMPANY_CAR as c 
where FIND_IN_SET('네비게이션', c.OPTIONS)
order by c.car_id desc