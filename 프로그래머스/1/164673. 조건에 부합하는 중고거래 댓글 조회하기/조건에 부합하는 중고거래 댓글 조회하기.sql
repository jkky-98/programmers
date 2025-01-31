select USED_GOODS_BOARD.TITLE, ugr.BOARD_ID, ugr.REPLY_ID, ugr.WRITER_ID, ugr.CONTENTS, DATE_FORMAT(ugr.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
from USED_GOODS_REPLY as ugr
left join USED_GOODS_BOARD on ugr.BOARD_ID = USED_GOODS_BOARD.BOARD_ID
where YEAR(USED_GOODS_BOARD.CREATED_DATE) = 2022 AND MONTH(USED_GOODS_BOARD.CREATED_DATE) = 10
order by ugr.CREATED_DATE ASC, USED_GOODS_BOARD.TITLE ASC
