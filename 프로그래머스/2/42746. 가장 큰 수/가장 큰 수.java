import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        List<String> strs = Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .collect(Collectors.toList());

        strs.sort((a, b) -> (b + a).compareTo(a + b));  // 핵심 정렬 기준

        // 모든 숫자가 0일 경우 "0" 한 번만 출력하기
        if (strs.get(0).equals("0")) {
            return "0";
        }

        return String.join("", strs);
    }
}
