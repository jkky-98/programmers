import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 사전순 정렬
        
        for (int i = 0; i < phone_book.length - 1; i++) {
            // 바로 다음 번호와 비교해서 접두어인지 확인
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
