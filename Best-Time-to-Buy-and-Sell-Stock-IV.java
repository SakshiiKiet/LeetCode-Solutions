1class Solution {
2    public int maxProfit(int k,int[] prices) {
3        int n = prices.length;
4
5        int[][] ahead = new int[2][k+1];
6        int[][] curr = new int[2][k+1];
7
8        for(int i = n - 1; i >= 0; i--) {
9            for(int buy = 0; buy <= 1; buy++) {
10                for(int cap = 1; cap <= k; cap++) {
11
12                    if(buy == 1) {
13                        curr[buy][cap] = Math.max(
14                            -prices[i] + ahead[0][cap],   // buy
15                            ahead[1][cap]                 // not buy
16                        );
17                    } else {
18                        curr[buy][cap] = Math.max(
19                            prices[i] + ahead[1][cap-1],  // sell
20                            ahead[0][cap]                 // not sell
21                        );
22                    }
23                }
24            }
25
26            // move current row to ahead
27            ahead=curr;
28        }
29
30        return ahead[1][k];
31    }
32}