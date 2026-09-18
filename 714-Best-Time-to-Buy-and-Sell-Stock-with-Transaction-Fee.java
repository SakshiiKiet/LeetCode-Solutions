class Solution {
    public int maxProfit(int[] prices,int fee) {
        int n=prices.length;
      int[][]  dp=new int[n+1][2];
       
        dp[n][0]=dp[n][1]=0;
        for(int i=n-1;i>=0;i--){
            for(int buy=1;buy>=0;buy--){
                 int profit=0;
        if(buy==1){
        profit=Math.max((-prices[i]+dp[i+1][0]), //buy
                        (0+dp[i+1][1]));          //not buy       
     }else{
        profit=Math.max((prices[i]-fee+dp[i+1][1]), //sell
                        (0+dp[i+1][0]));          //not sell      
              }
              dp[i][buy]=profit;
            }
        }
        return dp[0][1];
    }
}