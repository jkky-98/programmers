import java.util.*;

public class Solution {
    
    static Deque<Integer> queue;
    
    public int[] solution(int []arr) {
        queue = new ArrayDeque<>();
        
        for (int num : arr) {
            queue.offer(num);
        }
        
        List<Integer> resultList = new ArrayList<>();
        
        int num = queue.poll();
        resultList.add(num);
        
        while (!queue.isEmpty()) {
            int nextNum = queue.poll();
            
            if (nextNum == num) {
                continue;
            } else {
                num = nextNum;
                resultList.add(nextNum);
            }
        }
        
        return resultList.stream().mapToInt(i -> i.intValue()).toArray();
    }
}