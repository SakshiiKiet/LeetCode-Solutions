1class Solution {
2    public int uniquePaths(int m, int n) {
3
4        int[] dp = new int[n];
5
6        // Starting point
7        dp[0] = 1;
8
9        for (int i = 0; i < m; i++) {
10            for (int j = 1; j < n; j++) {
11                dp[j] = dp[j] + dp[j - 1];
12            }
13        }
14
15        return dp[n - 1];
16    }
17}