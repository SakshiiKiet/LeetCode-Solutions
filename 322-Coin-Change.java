class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];

        // Base case: using only coin[0]
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0)
                prev[t] = t / coins[0];
            else
                prev[t] = Integer.MAX_VALUE / 2;
        }

        // Fill DP table
        for (int i = 1; i < n; i++) {
            int[] curr=new int[amount+1];
            for (int j = 0; j <= amount; j++) {
                int notTake = prev[j];
                int take = Integer.MAX_VALUE / 2;

                if (j >= coins[i]) {
                    take = 1 + curr[j - coins[i]];
                }

                curr[j] = Math.min(take, notTake);
            }
            prev=curr;
        }

        int ans = prev[amount];
        return ans >= Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}