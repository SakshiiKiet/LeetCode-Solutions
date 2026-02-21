1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3        int m=obstacleGrid.length;
4        int n=obstacleGrid[0].length;
5       int[][] dp=new int[m][n];
6           for(int i=0;i<m;i++){
7            for(int j=0;j<n;j++){
8                if(obstacleGrid[i][j]==1){
9                  dp[i][j]=0; // for obstacle
10                } 
11                else if(i==0 && j==0){
12                 dp[i][j]=1;
13                }else{
14                   int up = 0;
15                int left = 0;
16
17                if (i > 0) up = dp[i - 1][j];
18                if (j > 0) left = dp[i][j - 1];
19
20                dp[i][j] = up + left;
21
22                }
23            }
24           }
25           return dp[m-1][n-1];
26    }
27}