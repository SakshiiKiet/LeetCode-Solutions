1class Solution {
2    public int maxProfit(int[] prices) {
3        int n=prices.length;
4      int[][]  dp=new int[n+2][2];
5       
6        dp[n][0]=dp[n][1]=0;
7        for(int i=n-1;i>=0;i--){
8            for(int buy=1;buy>=0;buy--){
9                 int profit=0;
10        if(buy==1){
11        dp[i][buy]=Math.max((-prices[i]+dp[i+1][0]), //buy
12                        (0+dp[i+1][1]));          //not buy       
13     }else{
14        dp[i][buy]=Math.max((prices[i]+dp[i+2][1]), //sell
15                        (0+dp[i+1][0]));          //not sell      
16              }
17            }
18        }
19        return dp[0][1];
20    }
21}