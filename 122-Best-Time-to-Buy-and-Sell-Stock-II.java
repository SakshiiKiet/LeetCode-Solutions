class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] ahead = new int[2];  // dp[i+1]
        int[] curr = new int[2];   // dp[i]

        ahead[0] = ahead[1] = 0;

        for(int i = n - 1; i >= 0; i--){
            for(int buy = 0; buy <= 1; buy++){

                if(buy == 1){
                    curr[buy] = Math.max(
                        -prices[i] + ahead[0],  // buy
                        ahead[1]                // not buy
                    );
                } else {
                    curr[buy] = Math.max(
                        prices[i] + ahead[1],   // sell
                        ahead[0]                // not sell
                    );
                }
            }
            ahead = curr;  // move to next iteration
        }

        return ahead[1];  // start with buy allowed
    }
}