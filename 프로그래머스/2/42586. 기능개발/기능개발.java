import java.util.*;

class Solution {
    static Deque<Integer> queue;
    
    public int[] solution(int[] progresses, int[] speeds) {
        
        queue = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            queue.offer(analysisDay(progresses[i], speeds[i]));
        }
        
        List<Integer> resultList = new ArrayList<>();
        int current = queue.poll();
        int count = 1;

        while (!queue.isEmpty()) {
            if (queue.peek() <= current) {
                queue.poll();
                count++;
            } else {
                resultList.add(count);
                current = queue.poll();
                count = 1;
            }
        }
        resultList.add(count); // 마지막 그룹

        return resultList.stream().mapToInt(i -> i.intValue()).toArray();
    }
    
    public int analysisDay(int progress, int speed) {
        int remainProgress = 100 - progress; // 0보다 무조건 큼 
        
        int remainDay = (int) Math.ceil((double) remainProgress / speed);
        
        return remainDay;
    }
}