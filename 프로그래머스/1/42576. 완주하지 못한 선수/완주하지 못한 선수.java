import java.util.*;

class Solution {
    static Map<String, Integer> map;
    
    public String solution(String[] participant, String[] completion) {
        
        map = new HashMap<>();
        
        setParticipantMap(participant);
        return getFail(completion);
    }
    
    public static void setParticipantMap(String[] participant) {
        for (int i = 0; i < participant.length; i++) {
            if (!map.containsKey(participant[i])) {
                map.put(participant[i], 1);
            } else {
                map.put(participant[i], map.get(participant[i]) + 1);
            }
        }
    }
    
    public static String getFail(String[] completion) {
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
            
            if (map.get(completion[i]).equals(0)) {
                map.remove(completion[i]);
            }
            
        }
        
        for (String key : map.keySet()) {
            return key;
        }
        
        return null;
    }
}