1class Solution {
2    public int maxProfit(int[] prices) {
3        int n=prices.length;
4        int[][][]dp =new int[n+1][2][3];
5        //cap=0
6        for(int i=0;i<n;i++){
7            for(int buy=0;buy<=1;buy++){
8                dp[i][buy][0]=0;
9            }
10        }
11        // index=n
12            for(int buy=0;buy<=1;buy++){
13                for(int cap=0;cap<=2;cap++){
14                dp[n][buy][cap]=0;
15            }
16        }
17        for(int i=n-1;i>=0;i--){
18            for(int buy=1;buy>=0;buy--){
19                for(int cap=2;cap>=1;cap--){
20            if(buy==1){
21            dp[i][buy][cap]=Math.max((-prices[i]+dp[i+1][0][cap]), //buy
22                        (0+dp[i+1][1][cap]));          //not buy       
23            }else{
24             dp[i][buy][cap]=Math.max((prices[i]+dp[i+1][1][cap-1]), //sell
25                        (0+dp[i+1][0][cap]));          //not sell      
26     }
27                }
28            }
29        }
30        
31        return dp[0][1][2];
32    }
33}