1class Solution {
2    public int maxProfit(int k,int[] prices) {
3
4        int n = prices.length;
5        int[][] ahead = new int[2][k+1];
6
7        for(int buy = 0; buy <= 1; buy++){
8            for(int cap = 0; cap <= k; cap++){
9                ahead[buy][cap] = 0;
10            }
11        }
12
13        for(int i = n - 1; i >= 0; i--) {
14
15            int[][] curr = new int[2][k+1];
16
17            // Explicit base case for cap == 0
18            for(int buy = 0; buy <= 1; buy++){
19                curr[buy][0] = 0;
20            }
21
22            for(int buy = 0; buy <= 1; buy++) {
23                for(int cap = 1; cap <= k; cap++) {
24
25                    if(buy == 1) {
26                        curr[buy][cap] = Math.max(
27                            -prices[i] + ahead[0][cap],   // buy
28                            ahead[1][cap]                 // not buy
29                        );
30                    } else {
31                        curr[buy][cap] = Math.max(
32                            prices[i] + ahead[1][cap-1],  // sell
33                            ahead[0][cap]                 // not sell
34                        );
35                    }
36                }
37            }
38
39            // Move current to ahead
40            ahead = curr;
41        }
42
43        return ahead[1][k];
44    }
45}