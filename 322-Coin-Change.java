class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        
       for(int j=0;j<=amount;j++){
          if(j%coins[0]==0){
                dp[0][j]= j/coins[0];
            }else{
             dp[0][j]=Integer.MAX_VALUE/2;
            }
       }
        if(amount==0) return 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
              int not=dp[i-1][j];
        int take=Integer.MAX_VALUE/2;
        if(j>=coins[i]){
            take=1+dp[i][j-coins[i]];
        }
        dp[i][j]=Math.min(take,not);
            }
        }
        
      int ans = dp[n-1][amount];

        return ans >= Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}