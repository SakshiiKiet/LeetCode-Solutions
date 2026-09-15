class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
       int[][] dp=new int[n][n];
      for(int j=0;j<n;j++){
        dp[0][j]=matrix[0][j];
      }
      for(int i=1;i<n;i++){
        for(int j=0;j<n;j++){
        int p=dp[i-1][j]+matrix[i][j];
        int q=Integer.MAX_VALUE;
        int r=Integer.MAX_VALUE;
        if(j-1>=0){
          q=dp[i-1][j-1]+matrix[i][j];
        }
         if(j+1<n){
          r=dp[i-1][j+1]+matrix[i][j];
         }
         dp[i][j]=Math.min(p,Math.min(q,r));
        }
      }
      int min=dp[n-1][0];
      for(int j=1;j<n;j++){
        min=Math.min(min,dp[n-1][j]);
      }
      return min;
    }
}