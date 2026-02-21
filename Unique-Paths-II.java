1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3        int m=obstacleGrid.length;
4        int n=obstacleGrid[0].length;
5       int[] dp = new int[n];
6
7        // Starting point
8         dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
9
10        for (int i = 0; i < m; i++) {
11            for (int j = 0; j < n; j++) {
12                if (obstacleGrid[i][j] == 1) {
13                    dp[j] = 0;              // blocked cell
14                }
15                else if (j > 0) {
16                    dp[j] = dp[j] + dp[j - 1]; // up + left
17                }
18            }
19        }
20
21        return dp[n - 1]; 
22  }
23}