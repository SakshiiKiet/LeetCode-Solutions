class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n][2];
        for(int[] rows:dp ){
            Arrays.fill(rows,-1);
        }
        return solve(0,1,prices);
    }
    int solve(int i,int buy,int[] prices){
        int n=prices.length;
        if(i==n){
            return 0;
        }
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            return dp[i][buy]= Math.max(-prices[i]+solve(i+1,0,prices),
                            0+solve(i+1,1,prices));
        }else{
           return dp[i][buy]=Math.max(prices[i]+solve(i+1,1,prices),
                           0+solve(i+1,0,prices));
        }
    }
}