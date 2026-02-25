1class Solution {
2    public int coinChange(int[] coins, int amount) {
3        int n = coins.length;
4        int[] prev = new int[amount + 1];
5
6        // Base case: using only coin[0]
7        for (int t = 0; t <= amount; t++) {
8            if (t % coins[0] == 0)
9                prev[t] = t / coins[0];
10            else
11                prev[t] = Integer.MAX_VALUE / 2;
12        }
13
14        // Fill DP table
15        for (int i = 1; i < n; i++) {
16            int[] curr=new int[amount+1];
17            for (int j = 0; j <= amount; j++) {
18                int notTake = prev[j];
19                int take = Integer.MAX_VALUE / 2;
20
21                if (j >= coins[i]) {
22                    take = 1 + curr[j - coins[i]];
23                }
24
25                curr[j] = Math.min(take, notTake);
26            }
27            prev=curr;
28        }
29
30        int ans = prev[amount];
31        return ans >= Integer.MAX_VALUE / 2 ? -1 : ans;
32    }
33}