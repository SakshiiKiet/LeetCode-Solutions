1class Solution {
2    int[][] dp;
3    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
4        int m=obstacleGrid.length;
5        int n=obstacleGrid[0].length;
6         dp=new int[m][n];
7         for(int[] row:dp){
8            Arrays.fill(row,-1);
9        }
10        return path(m-1,n-1,obstacleGrid);
11    }
12    int path(int i,int j,int[][] obstacleGrid){
13        if(i>=0 && j>=0 && obstacleGrid[i][j]==1) return 0;
14        if(i==0 && j==0) return 1;
15        if(i<0 || j<0) return 0;
16        if(dp[i][j]!=-1) return dp[i][j];
17        int up=path(i-1,j,obstacleGrid);
18        int left=path(i,j-1,obstacleGrid);
19        return dp[i][j]=up+left;
20    }
21}