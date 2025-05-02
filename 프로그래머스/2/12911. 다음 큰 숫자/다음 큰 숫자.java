import java.util.*;

class Solution {
    public int solution(int n) {
        
        String nbs = Integer.toBinaryString(n);
        int nbsOneCount = oneChecker(nbs);
        int next = n;
        while (true) {
            next++;
            
            String nextbs = Integer.toBinaryString(next);
            int nextbsOneCount = oneChecker(nextbs);
            
            if (nbsOneCount == nextbsOneCount) {
                return next;
            }
        }
    }
    
    public static int oneChecker(String bs) {
        int count = 0;
        for (int i = 0; i < bs.length(); i++) {
            char item = bs.charAt(i);
            if (item == '1') {
                count++;
            }
        }
        return count;
    }
}