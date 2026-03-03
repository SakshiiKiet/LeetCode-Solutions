1class Solution {
2    public int maxProfit(int[] prices) {
3
4        int n = prices.length;
5
6        // Represents dp[i+1]
7        int[][] ahead = new int[2][3];
8
9        // Explicit base case for i == n
10        for(int buy = 0; buy <= 1; buy++){
11            for(int cap = 0; cap <= 2; cap++){
12                ahead[buy][cap] = 0;
13            }
14        }
15
16        for(int i = n - 1; i >= 0; i--) {
17
18            int[][] curr = new int[2][3];
19
20            // Explicit base case for cap == 0
21            for(int buy = 0; buy <= 1; buy++){
22                curr[buy][0] = 0;
23            }
24
25            for(int buy = 0; buy <= 1; buy++) {
26                for(int cap = 1; cap <= 2; cap++) {
27
28                    if(buy == 1) {
29                        curr[buy][cap] = Math.max(
30                            -prices[i] + ahead[0][cap],   // buy
31                            ahead[1][cap]                 // not buy
32                        );
33                    } else {
34                        curr[buy][cap] = Math.max(
35                            prices[i] + ahead[1][cap-1],  // sell
36                            ahead[0][cap]                 // not sell
37                        );
38                    }
39                }
40            }
41
42            // Move current to ahead
43            ahead = curr;
44        }
45
46        return ahead[1][2];
47    }
48}