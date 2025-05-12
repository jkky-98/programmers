import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        List<Set<Integer>> nodeInfos = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        // 노드 생성
        nodeInfos.add(new HashSet<>());
        
        for (int i = 0; i < n; i++) {
            nodeInfos.add(new HashSet<>());
        }
        // wires 정보 삽입
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            
            linkNodeInfo(start, end, nodeInfos);
        }
        
        // wires 하나씩 끊기
        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];
            
            unlinkNodeInfo(start, end, nodeInfos);
            boolean[] visited = new boolean[n+1];
            // start BFS
            int startCount = 0;
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(start);
            visited[start] = true;
            
            while (!queue.isEmpty()) {
                int startTmp = queue.poll();
                Set<Integer> startNode = nodeInfos.get(startTmp);
                
                for (int node : startNode) {
                    if (!visited[node]) {
                        visited[node] = true;
                        startCount++;
                        queue.offer(node);
                    }
                } 
            }
            // end BFS
            int endCount = 0;
            queue.clear();
            queue.offer(end);
            visited[end] = true;
            
            while (!queue.isEmpty()) {
                int endTmp = queue.poll();
                Set<Integer> endNode = nodeInfos.get(endTmp);
                
                for (int node : endNode) {
                    if (!visited[node]) {
                        visited[node] = true;
                        endCount++;
                        queue.offer(node);
                    }
                } 
            }
            // 양쪽 결과 차이 쓰기
            resultList.add(Math.abs(startCount - endCount));
            // 복구
            linkNodeInfo(start, end, nodeInfos);
        }
        return Collections.min(resultList);
    }
    
    public static void linkNodeInfo(int start, int end, List<Set<Integer>> nodeInfos) {
        nodeInfos.get(start).add(end);
        nodeInfos.get(end).add(start);
    }
    
    public static void unlinkNodeInfo(int start, int end, List<Set<Integer>> nodeInfos) {
        nodeInfos.get(start).remove(end);
        nodeInfos.get(end).remove(start);
    }
}