import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int number = brown + yellow;
        
        List<int[]> pairs = new ArrayList<>();
        
        for (int i = 3; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                int a = i;
                int b = number / i;
                if (a <= b && b >= 3) {
                    pairs.add(new int[]{b,a});
                }
            }
        }
        
        // pairs 경우의 수 처리
        for (int[] pair : pairs) {
            int yellowCandidate = (pair[0] - 2 ) * (pair[1] - 2);
            if (yellowCandidate == yellow) {
                return pair;
            }
        }

        return new int[]{-1,-1};
    }
}