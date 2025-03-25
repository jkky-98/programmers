import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, List<String>> userInfo = new HashMap<>();
        Map<String, Integer> userHowMany = new HashMap<>();
        
        for (String user : id_list) {
            userInfo.put(user, new ArrayList<>());
            userHowMany.put(user, 0);
        }
        // 리포트 사항 기입
        for (String request : report) {
            String[] requestAll = request.split(" ");
            
            String requester = requestAll[0];
            String target = requestAll[1];
            
            if (!userInfo.get(requester).contains(target)) {
                userInfo.get(requester).add(target);
                userHowMany.put(target, userHowMany.get(target) + 1);
            }
        }
        // 리포트 분석
        int[] result = new int[id_list.length];
        for (int i=0; i<id_list.length; i++) {
            List<String> targets = userInfo.get(id_list[i]);
            for (String target : targets) {
                if (userHowMany.get(target) >= k) {
                    result[i]++;
                }
            }
        }
        return result;
    }
}