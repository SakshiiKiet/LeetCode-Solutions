1class Solution {
2    public int maxProfit(int[] prices) {
3        int n = prices.length;
4
5        int[] ahead = new int[2];  // dp[i+1]
6        int[] curr = new int[2];   // dp[i]
7
8        ahead[0] = ahead[1] = 0;
9
10        for(int i = n - 1; i >= 0; i--){
11            for(int buy = 0; buy <= 1; buy++){
12
13                if(buy == 1){
14                    curr[buy] = Math.max(
15                        -prices[i] + ahead[0],  // buy
16                        ahead[1]                // not buy
17                    );
18                } else {
19                    curr[buy] = Math.max(
20                        prices[i] + ahead[1],   // sell
21                        ahead[0]                // not sell
22                    );
23                }
24            }
25            ahead = curr;  // move to next iteration
26        }
27
28        return ahead[1];  // start with buy allowed
29    }
30}