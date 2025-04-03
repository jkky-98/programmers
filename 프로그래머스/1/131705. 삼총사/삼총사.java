class Solution {
    
    public boolean[] visited;
    public int answer;
    
    public int solution(int[] number) {
        visited = new boolean[number.length];
        
        bt(0, 0, 0, number);
        
        return answer;
    }
    
    public void bt(int index, int depth, int sum, int[] number) {
        if (depth == 3) {
            if (sum == 0) {
                answer++;
            }
            return;
        }
        
        for (int i = index; i < number.length; i++) {
            if (!visited[index]) {
                visited[index] = true;
                bt(i + 1, depth + 1, sum + number[i], number);
                visited[index] = false;      
            }  
        }
    }
}