1class Solution {
2    public int maxProfit(int[] prices) {
3
4        int n = prices.length;
5
6        int[] front1 = new int[2];  // dp[i+1]
7        int[] front2 = new int[2];  // dp[i+2]
8    
9
10        // Base case: all already 0
11        front1[0] = 0;  // sell state
12        front1[1] = 0;  // buy state
13
14        front2[0] = 0;  
15        front2[1] = 0;
16
17        for(int i = n - 1; i >= 0; i--) {
18            int[] curr = new int[2];
19            // BUY state
20            curr[1] = Math.max(
21                -prices[i] + front1[0],  // buy
22                front1[1]                // not buy
23            );
24
25            // SELL state (cooldown → use front2)
26            curr[0] = Math.max(
27                prices[i] + front2[1],   // sell
28                front1[0]                // not sell
29            );
30
31            // Shift forward
32            front2 = front1;
33            front1 = curr;  // clone to avoid reference issue
34        }
35
36        return front1[1];
37    }
38}