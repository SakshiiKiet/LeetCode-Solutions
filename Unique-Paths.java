1class Solution {
2    int dp[][];
3    public int uniquePaths(int m, int n) {
4        dp=new int[m][n];
5        for(int[] row:dp){
6            Arrays.fill(row,-1);
7        }
8       return path(m-1,n-1);
9    }
10    int path(int i,int j){
11        if(i==0 && j==0) return 1;
12       if(i<0 || j<0) return 0;
13       if(dp[i][j]!=-1) return dp[i][j];
14       int up=path(i-1,j);
15       int left=path(i,j-1);
16       return dp[i][j]=up+left;
17    }
18}