1class Solution {
2    int[][]dp;
3    public int maxProfit(int[] prices) {
4        int n = prices.length;
5        dp=new int[n][4];
6        for(int[] rows:dp){
7            Arrays.fill(rows,-1);
8        }
9        return profit(0,0,prices);
10    }
11    int profit(int i,int trans,int[] prices){
12        if(i==prices.length || trans==4)  return 0;
13        if(dp[i][trans]!=-1) return dp[i][trans];
14        int profit;
15        if(trans%2==0){ //buy
16          dp[i][trans]=Math.max((-prices[i]+profit(i+1,trans+1,prices)),(0+profit(i+1,trans,prices)));
17        }else{
18           dp[i][trans]=Math.max((prices[i]+profit(i+1,trans+1,prices)),(0+profit(i+1,trans,prices))) ;
19        }
20        return dp[i][trans];
21    }
22
23}