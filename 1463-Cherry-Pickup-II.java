class Solution {
    int[][][]dp;
    public int cherryPickup(int[][] grid) {
         int m=grid[0].length;
         int n=grid.length;
         dp=new int[n][m][m];
         
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2){
                dp[n-1][j1][j2]= grid[n-1][j1];
            }else{
                 dp[n-1][j1][j2]=grid[n-1][j1]+grid[n-1][j2];
            }
            }
        }
        
       for(int i=n-2;i>=0;i--){
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                int max=Integer.MIN_VALUE;
                for(int dj1=-1;dj1<=1;dj1++){
                    for(int dj2=-1;dj2<=1;dj2++){
                            int nj1 = j1 + dj1;
                            int nj2 = j2 + dj2;

                            if (nj1 >= 0 && nj1 < m && nj2 >= 0 && nj2 < m) {
                                if(j1==j2){
                                    max=Math.max(max,dp[i + 1][nj1][nj2]+grid[i][j1]);
                                }else{
                                    max=Math.max(max,dp[i + 1][nj1][nj2]+grid[i][j1]+grid[i][j2]);
                                }
                            }
                    }
                }
              dp[i][j1][j2]=max;
            }
        }
       }
        return dp[0][0][m-1];
    }
}