class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int mod = 1234567;

        for (int i = 2; i <= n; i++) {
            dp[i] = ((dp[i - 1] % mod) + (dp[i - 2] % mod)) % mod;
        }

        return dp[n];
    }
}
