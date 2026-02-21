1class Solution {
2    public int uniquePaths(int m, int n) {
3
4        int[][] dp = new int[m][n];
5        dp[0][0] = 1;
6
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9
10                if (i == 0 && j == 0) continue;
11
12                int up = 0;
13                int left = 0;
14
15                if (i > 0) up = dp[i - 1][j];
16                if (j > 0) left = dp[i][j - 1];
17
18                dp[i][j] = up + left;
19            }
20        }
21
22        return dp[m - 1][n - 1];
23    }
24}