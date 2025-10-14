import java.util.*;

class Solution {

    static int boat = 0;
    static Deque<Integer> humanQ;
    
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        humanQ = new ArrayDeque<>();
        
        for (int human : people) {
            humanQ.offer(human);
        }
        
        while (!humanQ.isEmpty()) {
            createFullBoat(limit);
        }
        
        return boat;
    }
    
    public void createFullBoat(int limit) {
        // 0. 보트 사용한거임
        boat++;
        // 1. 우선 뚱땡이 처리
        int hugeMan = humanQ.pollLast();
        limit = limit - hugeMan;
        
        // 2. 멸치 처리 가능 여부 확인후 최대 2명까지 태우기
        
        if (humanQ.isEmpty()) {
            return;
        }
        
        int thinMan = humanQ.peekFirst();
        
        if (thinMan > limit) {
            return;
        } else {
            limit = limit - humanQ.pollFirst();
        }
        
    }
}