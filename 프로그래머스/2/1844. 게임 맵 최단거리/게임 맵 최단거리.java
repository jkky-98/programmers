import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static Deque<Step> queue;
    static int[] drow;
    static int[] dcol;
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        queue = new ArrayDeque<>();
        
        drow = new int[] {-1, 1, 0, 0};
        dcol = new int[] {0, 0, -1, 1};
        
        return BFS(maps);
    }
    
    static int BFS(int[][] maps) {
        queue.offer(new Step(0, 0, 0));
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            Step step = queue.poll();
            int row = step.row;    
            int col = step.col;
            int count = step.count;
            
            if (row == maps.length - 1 && col == maps[0].length - 1) {
                return count + 1;
            }
            
            for (int i = 0; i < 4; i++) {
                if (row + drow[i] >= 0 &&
                    row + drow[i] < maps.length &&
                    col + dcol[i] >= 0 &&
                    col + dcol[i] < maps[0].length &&
                    maps[row + drow[i]][col + dcol[i]] != 0 &&
                    !visited[row + drow[i]][col + dcol[i]]
                   )  {

                    visited[row + drow[i]][col + dcol[i]] = true;
                    queue.offer(new Step(row + drow[i], col + dcol[i], count + 1));

                }
            }
        }
        
        return -1;
    }
    
    static class Step {
        public int count;
        public int row;
        public int col;
        
        public Step(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}