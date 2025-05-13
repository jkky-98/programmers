import java.util.*;

class Solution {
    
    public static List<Set<Integer>> nodes;
    public static boolean[] visited;
    public static Deque<Integer> queue;
    public static List<Integer> resultList;
    
    public int solution(int n, int[][] wires) {
        initNodes(n);
        visited = new boolean[n + 1];
        queue = new ArrayDeque<>();
        resultList = new ArrayList<>();
        
        for (int[] wire : wires) {
            link(wire);
        }
        // wire 하나씩 끊어보며 송전탑 개수 차이 계산 wire복구 필수
        for (int[] wire : wires) {
            unlink(wire);
            // BFS 서칭 -> 송전탑 개수 차이 판단
            int etopDiff = Math.abs(bfs(wire[0]) - bfs(wire[1]));
            resultList.add(etopDiff);
            link(wire);
        }
        
        return Collections.min(resultList);
    }
    public static int bfs(int start) {
        // 초기화
        int count = 0;
        queue.clear();
        Arrays.fill(visited, false);
        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int link = queue.poll();
            Set<Integer> node = nodes.get(link);
            
            for (int linkFromNode : node) {
                if (!visited[linkFromNode]) {
                    // queue에 link넣기 전에 처리 작업
                    count++;
                    visited[linkFromNode] = true;
                    // queue에 link넣기
                    queue.offer(linkFromNode);
                }
            }
        }
        
        return count;
    }
    
    public static void unlink(int[] wire) {
        int start = wire[0];
        int end = wire[1];
        
        nodes.get(start).remove(end);
        nodes.get(end).remove(start);
    }
    
    
    public static void link(int[] wire) {
        int start = wire[0];
        int end = wire[1];

        nodes.get(start).add(end);
        nodes.get(end).add(start);
    }
    
    public static void initNodes(int n) {
        nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            nodes.add(new HashSet<>());
        }
    }
}