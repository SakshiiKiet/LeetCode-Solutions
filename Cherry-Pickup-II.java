1class Solution {
2    int dp[][][];
3    public int cherryPickup(int[][] grid) {
4        int n=grid.length;
5        int m=grid[0].length;
6        dp=new int[n][m][m];
7        dp = new int[n][m][m];
8        for (int i = 0; i < n; i++) {
9        for (int j = 0; j < m; j++) {
10        Arrays.fill(dp[i][j], -1);
11    }
12}
13        return path(0,0,m-1,grid);
14    }
15    int path(int i,int j1, int j2,int[][] grid){
16        int n=grid.length;
17        int m=grid[0].length;
18        if(j1<0 || j1>=m || j2<0 || j2>=m) return Integer.MIN_VALUE/2;
19        if(i==n-1){
20            if(j1==j2){
21                return grid[i][j1];
22            }else{
23                return grid[i][j1]+grid[i][j2];
24            }
25        }
26        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
27        int max=Integer.MIN_VALUE;
28        for(int dj1=-1;dj1<=1;dj1++){
29         for(int dj2=-1;dj2<=1;dj2++){
30           if(j1==j2){
31            max=Math.max(max,grid[i][j1]+path(i+1,j1+dj1,j2+dj2,grid));
32           } else{
33             max=Math.max(max,grid[i][j1]+grid[i][j2]+path(i+1,j1+dj1,j2+dj2,grid));
34           }  
35            }
36        }
37        return dp[i][j1][j2]=max;
38    }
39}