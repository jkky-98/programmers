-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, COALESCE(TLNO, "NONE") as TLNO
from PATIENT as p
where p.AGE < 13 AND p.GEND_CD = 'W'
order by p.AGE DESC, p.PT_NAME ASC
