import java.util.*;

class Solution {
    
    static Map<String, Integer> map;
    
    public String solution(String[] participant, String[] completion) {
        // map 초기화
        map = new HashMap<>();
        
        // map에 completion 정보 넣기
        for (String c : completion) {
            int cValue = map.getOrDefault(c, 0);
            
            if (cValue == 0) {
                map.put(c, 1);
            } else {
                map.put(c, cValue + 1);
            }
        }
        
        // participant 순회하며 map안의 정보 줄여나가기, 만약 정보가 없는데 줄일려고 하면 그녀석이 정답!
        for (String p : participant) {
            
            int pValue = map.getOrDefault(p, 0);
            
            if (pValue == 0) {
                return p;
            }
            
            // 소거 로직
            if (pValue == 1) {
                map.remove(p);
            } else {
                map.put(p, pValue-1);
            }
        }
        
        return null;
    }
    // 여기서 알아가야할 점.
    // map의 메서드를 알 수가 있다. getOrDefault(key, defaultValue), 이거랑 remove(key)
}