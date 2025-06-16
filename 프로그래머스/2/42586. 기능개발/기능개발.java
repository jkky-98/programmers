import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int n = progresses.length;
        int[] days = new int[n];
        
        for (int i = 0; i < n; i++) {
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        int maxDay = days[0];
        int count = 1;
        
        for (int i = 1; i < n; i++) {
            if (days[i] <= maxDay) {
                count++;
            } else {
                result.add(count);
                count = 1;
                maxDay = days[i];
            }
        }
        result.add(count); // 마지막 배포

        return result.stream().mapToInt(i -> i).toArray();
    }
}
