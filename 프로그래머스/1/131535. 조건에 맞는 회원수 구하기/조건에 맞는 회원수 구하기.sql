-- 코드를 입력하세요
SELECT count(*) as USERS
from USER_INFO as ui
where ui.AGE >= 20 AND ui.AGE <= 29 AND YEAR(JOINED) = 2021