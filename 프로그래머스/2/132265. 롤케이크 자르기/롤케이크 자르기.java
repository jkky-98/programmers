import java.util.*;
import java.util.stream.Collectors;


class Solution {
    public int solution(int[] topping) {
    
        List<List<Integer>> mapList = new ArrayList<>();
        
        int leftCount;
        int rightCount;
        int[] leftMap = new int[10002];
        int[] rightMap = new int[10002];
        Integer count = 0;
        
        for (int i = 0; i <= topping.length - 2; i++) {
            count = cut(mapList, topping, i, leftMap, rightMap, count);
        }
        
        return count;
    }
    
    private Integer cut(List<List<Integer>> mapList, int[] topping, int idx, int[] leftMap, int[] rightMap, Integer count) {
        // 초기 구성
        if (idx == 0) {
            Set<Integer> leftSet = new HashSet<>();
            Set<Integer> rightSet = new HashSet<>();
            
            for (int i = 0; i <= idx; i++) {
                leftSet.add(topping[i]);
                leftMap[topping[i]] ++;
            }
            
            for (int i = idx + 1; i < topping.length; i++) {
                rightSet.add(topping[i]);
                rightMap[topping[i]] ++;
            }
            
            mapList.add(List.of(leftSet.size(), rightSet.size()));
        // idx = 1부터    
        } else {
            List<Integer> mapEntry = mapList.get(idx - 1);
            
            int leftUnique = mapEntry.get(0);
            int rightUnique = mapEntry.get(1);
            
            int toppingType = topping[idx];
            
            rightMap[toppingType] --;
            
            if (leftMap[toppingType] == 0) {
                leftMap[toppingType] ++;
                leftUnique ++;
            } else {
                leftMap[toppingType] ++;
            }
            
            if (rightMap[toppingType] == 0) {
                rightUnique --;
            }
            
            if (leftUnique == rightUnique && leftUnique !=0 && rightUnique !=0) {
                count = count + 1;
            }
            
            mapList.add(List.of(leftUnique, rightUnique));
            
            return count;
        }
        
        return 0;
    }
}