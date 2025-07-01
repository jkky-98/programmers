import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        int idx = 0;
        
        for (int[] command : commands) {
            int result = findByRule(array, command);
            answer[idx++] = result;
        }
        return answer;
    }
    
    public int findByRule(int[] array, int[] command) {
        // 번째의 함정 조심
        int startIdx = command[0] - 1;
        int endIdx = command[1] - 1;
        int pickIdxAfterSort = command[2] - 1;
        
        int length = endIdx - startIdx + 1;
        
        int[] newArray = new int[length];
        
        // 새로운 Array에 채우기
        int idx = 0;
        for (int i = startIdx; i <= endIdx; i++) {
            newArray[idx] = array[i];
            idx++;
        }
        
        Arrays.sort(newArray);
        
        return newArray[pickIdxAfterSort];
    }
}