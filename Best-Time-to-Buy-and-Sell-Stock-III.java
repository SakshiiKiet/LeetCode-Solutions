1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4        int[][] dp=new int[n+1][4+1];
5        for(int trans=0;trans<4;trans++){
6            dp[n][trans]=0;
7        }
8        for(int i=1;i<=n;i++){
9            dp[i][4]=0;
10        }
11        for(int i=n-1;i>=0;i--){
12          for(int trans=3;trans>=0;trans--){
13             if(trans%2==0){ //buy
14          dp[i][trans]=Math.max(-prices[i]+dp[i+1][trans+1],0+dp[i+1][trans]);
15        }else{
16           dp[i][trans]=Math.max(prices[i]+dp[i+1][trans+1],0+dp[i+1][trans]) ;
17        }
18          }
19        }
20       
21        return dp[0][0];
22    }
23}