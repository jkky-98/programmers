class Solution {
    public int solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int tmpCount = 0;
            for (int j = i; j <= n; j++) {
                tmpCount += j;
                if (tmpCount == n) {
                    count++;
                    break;
                } else if (tmpCount > n) {
                    break;
                }
            }
        }
        return count;
    }
}