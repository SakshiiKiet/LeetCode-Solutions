1class Solution {
2    int[][]dp;
3    public int maxProfit(int k,int[] prices) {
4        int n = prices.length;
5        dp=new int[n][2*k];
6        for(int[] rows:dp){
7            Arrays.fill(rows,-1);
8        }
9        return profit(0,0,k,prices);
10    }
11    int profit(int i,int trans,int k,int[] prices){
12        if(i==prices.length || trans==2*k)  return 0;
13        if(dp[i][trans]!=-1) return dp[i][trans];
14        if(trans%2==0){ //buy
15          dp[i][trans]=Math.max((-prices[i]+profit(i+1,trans+1,k,prices)),(0+profit(i+1,trans,k,prices)));
16        }else{
17           dp[i][trans]=Math.max((prices[i]+profit(i+1,trans+1,k,prices)),(0+profit(i+1,trans,k,prices))) ;
18        }
19        return dp[i][trans];
20    }
21
22}