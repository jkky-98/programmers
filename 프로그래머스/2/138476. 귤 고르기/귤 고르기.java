import java.util.*;

class Solution {
    
    static Map<Integer, Integer> tangMap = new HashMap<>();
    static Map<Integer, Deque<Integer>> treeMap = new TreeMap<>(Comparator.reverseOrder());
    static int result = 0;
    
    public int solution(int k, int[] tangerine) {
        
        for (int t : tangerine) {
            if (tangMap.containsKey(t)) {
                // 존재할 경우
                tangMap.put(t, tangMap.get(t) + 1);
            } else {
                // 존재 x
                tangMap.put(t, 1);
            }
        }
        
        // TreeMap으로 key, value 역전시키기
        for (Map.Entry<Integer, Integer> entry: tangMap.entrySet()) {
            int tangerineSize = entry.getKey();
            int tangerineCount = entry.getValue();
            
            if (treeMap.containsKey(tangerineCount)) {
                treeMap.get(tangerineCount).offer(tangerineSize);
            } else {
                treeMap.put(tangerineCount, new ArrayDeque<>());
                treeMap.get(tangerineCount).offer(tangerineSize);
            }
        }

        // 귤 쌓기
        for (Map.Entry<Integer, Deque<Integer>> entry : treeMap.entrySet()) {
            int count = entry.getKey();
            Deque<Integer> sizes = entry.getValue();
            
            while (!sizes.isEmpty()) {
                int size = sizes.poll();
                k = k - count;
                result++;
                if (k <= 0) {
                    return result;
                }
            }
        }
        
        
        int answer = 0;
        return answer;
    }
}