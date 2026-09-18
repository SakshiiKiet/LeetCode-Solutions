class Solution {
    int[][][]dp;
    public int maxProfit(int[] prices) {
        int n=prices.length;
        dp=new int[n][2][3];
         for(int i = 0; i < n; i++){
    for(int j = 0; j < 2; j++){
        Arrays.fill(dp[i][j], -1);
    }
}
       return profit(0,1,2,prices);
    }
    int profit(int i,int buy,int cap,int[] prices){
        if(cap==0) return 0;
        if(i==prices.length) return 0;
        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        int profit=0;
        if(buy==1){
        profit=Math.max((-prices[i]+profit(i+1,0,cap,prices)), //buy
                        (0+profit(i+1,1,cap,prices)));          //not buy       
     }else{
        profit=Math.max((prices[i]+profit(i+1,1,cap-1,prices)), //sell
                        (0+profit(i+1,0,cap,prices)));          //not sell      
     }
        return dp[i][buy][cap]=profit;
    }
}