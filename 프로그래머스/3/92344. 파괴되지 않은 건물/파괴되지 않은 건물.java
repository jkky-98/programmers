class Solution {
    public int solution(int[][] board, int[][] skill) {
        int rowLen = board.length;
        int colLen = board[0].length;
        
        int[][] map = new int[rowLen + 1][colLen + 1];
        // 스킬 적용
        for (int[] unitSkill : skill) {
            playSkill(unitSkill, map);
        }
        // 누적합
        prefixSum(map);
        // 기존 배열에 누적합 배열 더해주기
        totalSum(map, board);
        // 파괴되지 않은 건물의 개수 구하기
        int count = getNotDestroied(board);
        
        return count;
    }
    private int getNotDestroied(int[][] board) {
        int count = 0;
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                if (board[i][j] > 0) {
                    count++;                    
                }
            }
        }
        return count;
    }
    
    private void totalSum(int[][] map, int[][] board) {
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                board[i][j] += map[i][j];
            }
        }
    }
    
    private void prefixSum(int[][] map) {
        // 열 누적합
        for (int i=0; i < map.length; i++) {
            for (int j=1; j < map[0].length; j++) {
                map[i][j] = map[i][j - 1] + map[i][j];
            }
        }
        
        // 행 누적합
        for (int i=0; i < map[0].length; i++) {
            for (int j=1; j < map.length; j++) {
                map[j][i] = map[j - 1][i] + map[j][i];
            }
        }
    }
    
    private void playSkill(int[] unitSkill, int[][] map) {
        // 공격 or 회복 판단
        int skillType = 0;
            
        if (unitSkill[0] == 1) {
            skillType = -1;
        } else {
            skillType = 1;
        }
        // prefixSum update
        int r1 = unitSkill[1];
        int c1 = unitSkill[2];
        int r2 = unitSkill[3];
        int c2 = unitSkill[4];
        int degree = unitSkill[5] * skillType;
        
        map[r1][c1] += degree;
        map[r2 + 1][c1] -= degree;
        map[r1][c2 + 1] -= degree;
        map[r2 + 1][c2 + 1] += degree;
    }
}