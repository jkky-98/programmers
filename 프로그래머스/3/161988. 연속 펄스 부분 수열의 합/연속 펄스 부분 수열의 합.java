import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        
        int purse = 1;
        int purse2 = -1;
        
        int[] seqPulse1 = new int[sequence.length];
        int[] seqPulse2 = new int[sequence.length];
        
        for (int i = 0; i < sequence.length; i++) {
            seqPulse1[i] = sequence[i] * purse;
            purse = purse * -1;
        }
        
        for (int i = 0; i < sequence.length; i++) {
            seqPulse2[i] = sequence[i] * purse2;
            purse2 = purse2 * -1;
        }
        
        long[] prefix1 = getPrefixSumArray(seqPulse1);
        long[] prefix2 = getPrefixSumArray(seqPulse2);
        
        long result1 = searchMax(prefix1);
        long result2 = searchMax(prefix2);
        
        return Math.max(result1, result2);
    }
    
    private static long[] getPrefixSumArray(int[] seq) {
        long[] returnArray = new long[seq.length];
        
        for (int i = 0; i < seq.length; i ++) {
            if (i == 0) {
                returnArray[0] = seq[0];
            } else {
                returnArray[i] = returnArray[i - 1] + seq[i];
            }
        }
        
        return returnArray;
    }
    
    private static long searchMax(long[] prefix) {
        long max = prefix[0];
        int maxIndex = 0;
        // max 값 위치 찾기
        
        for (int i = 0; i < prefix.length; i++) {
            if (prefix[i] > max) {
                max = prefix[i];
                maxIndex = i;
            }
        }

        // 0 ~ maxIndex - 1까지 최솟값 찾기
        long min = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (prefix[i] < min) {
                min = prefix[i];
            }
        }
        
        return max - min;
    }
}