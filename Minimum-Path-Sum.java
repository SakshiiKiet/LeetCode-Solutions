1class Solution {
2    public int minPathSum(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int[][] dp = new int[m][n];
6       for(int i=0;i<m;i++){
7        for(int j=0;j<n;j++){
8            if(i==0 && j==0){
9                dp[i][j]=grid[0][0];
10            }else{
11                 int up = Integer.MAX_VALUE;
12                    int left = Integer.MAX_VALUE;
13
14                if (i > 0) up = grid[i][j] +dp[i - 1][j];
15                if (j > 0) left = grid[i][j] +dp[i][j - 1];
16                dp[i][j]=Math.min(up,left);
17            }
18        }
19       }
20        return dp[m-1][n-1];
21    }
22}