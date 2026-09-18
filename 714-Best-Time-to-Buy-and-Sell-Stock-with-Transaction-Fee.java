class Solution {
    int[][]dp;
    public int maxProfit(int[] prices,int fee) {
        int n=prices.length;
        dp=new int[n][2];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
       return profit(0,1,prices,fee);
    }
    int profit(int i,int buy,int[] prices,int fee){
        if(i==prices.length) return 0;
        int profit=0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
        profit=Math.max((-prices[i]+profit(i+1,0,prices,fee)), //buy
                        (0+profit(i+1,1,prices,fee)));          //not buy       
     }else{
        profit=Math.max((prices[i]-fee+profit(i+1,1,prices,fee)), //sell
                        (0+profit(i+1,0,prices,fee)));          //not sell      
     }
        return dp[i][buy]= profit;
    }
}