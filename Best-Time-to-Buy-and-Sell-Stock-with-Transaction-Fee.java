1class Solution {
2    public int maxProfit(int[] prices,int fee) {
3        int n=prices.length;
4      int[][]  dp=new int[n+1][2];
5       
6        dp[n][0]=dp[n][1]=0;
7        for(int i=n-1;i>=0;i--){
8            for(int buy=1;buy>=0;buy--){
9                 int profit=0;
10        if(buy==1){
11        profit=Math.max((-prices[i]+dp[i+1][0]), //buy
12                        (0+dp[i+1][1]));          //not buy       
13     }else{
14        profit=Math.max((prices[i]-fee+dp[i+1][1]), //sell
15                        (0+dp[i+1][0]));          //not sell      
16              }
17              dp[i][buy]=profit;
18            }
19        }
20        return dp[0][1];
21    }
22}