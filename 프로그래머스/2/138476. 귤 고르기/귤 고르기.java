import java.util.*;

class Solution {    
    public int solution(int k, int[] tangerine) {
        // 2차 풀이
        // getOrDefault() 사용
        // Collections.sort(콜렉션, Comparators.reverseOrder()) 사용
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> countList = new ArrayList<>(map.values());
        
        // desc 정렬
        Collections.sort(countList, Comparator.reverseOrder());
        
        int answer = 0;
        for (int count : countList) {
            answer++;
            k = k - count;
            if (k <= 0) {
                return answer;
            }
        }
        
        return -1;
    }
}