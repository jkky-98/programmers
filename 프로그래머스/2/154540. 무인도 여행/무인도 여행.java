import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static char[][] map;
    static Deque<int[]> queue;
    static int[] dx;
    static int[] dy;
    
    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        map = new char[maps.length][maps[0].length()];
        queue = new ArrayDeque<>();
        
        dx = new int[] {-1, 1, 0, 0};
        dy = new int[] {0, 0, 1, -1};
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        // 서치 시작
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {
                    int localResult = DFS(i, j);
                    result.add(localResult);
                }
            }
        }
        if (result.size() == 0) {
            return new int[] {-1};
        }
        
        Collections.sort(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
    // DFS 가동
    public int DFS(int startRow, int startCol) {
        queue.clear();
        queue.offer(new int[] {startRow, startCol});
        visited[startRow][startCol] = true;
        int count = Character.getNumericValue(map[startRow][startCol]);
        
        while (!queue.isEmpty()) {
            int[] yx = queue.poll();
            int row = yx[0];
            int col = yx[1];
            
            for (int i = 0; i < 4; i++) {
                if (row + dx[i] >= 0 &&
                    row + dx[i] < map.length &&
                    col + dy[i] >= 0 &&
                    col + dy[i] < map[0].length &&
                    !visited[row + dx[i]][col + dy[i]] &&
                    map[row + dx[i]][col + dy[i]] != 'X'
                   ) {
                    queue.offer(new int[] {row + dx[i], col + dy[i]});
                    visited[row + dx[i]][col + dy[i]] = true;
                    count += Character.getNumericValue(map[row + dx[i]][col + dy[i]]);
                }
            }
        }

        return count;
    }
}