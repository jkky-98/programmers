import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int maxPick = nums.length / 2;
        Set<Integer> numsUnique = new HashSet<>();
        
        for (int num : nums) {
            numsUnique.add(num);
        }
        
        int maxUnique = numsUnique.size();
        
        if (maxPick >= maxUnique) {
            return maxUnique;
        } else {
            return maxPick;
        }
    }
}