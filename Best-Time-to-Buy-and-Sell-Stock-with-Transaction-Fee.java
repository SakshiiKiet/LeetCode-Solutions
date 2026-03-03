1class Solution {
2    int[][]dp;
3    public int maxProfit(int[] prices,int fee) {
4        int n=prices.length;
5        dp=new int[n][2];
6        for(int[] rows:dp){
7            Arrays.fill(rows,-1);
8        }
9       return profit(0,1,prices,fee);
10    }
11    int profit(int i,int buy,int[] prices,int fee){
12        if(i==prices.length) return 0;
13        int profit=0;
14        if(dp[i][buy]!=-1) return dp[i][buy];
15        if(buy==1){
16        profit=Math.max((-prices[i]+profit(i+1,0,prices,fee)), //buy
17                        (0+profit(i+1,1,prices,fee)));          //not buy       
18     }else{
19        profit=Math.max((prices[i]-fee+profit(i+1,1,prices,fee)), //sell
20                        (0+profit(i+1,0,prices,fee)));          //not sell      
21     }
22        return dp[i][buy]= profit;
23    }
24}