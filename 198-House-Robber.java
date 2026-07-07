class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;
       
        int prev2 = 0;        // dp[i-2]
        int prev1 = nums[0]; // dp[i-1]

        for (int i = 1; i < n; i++) {
            int pick = nums[i] + prev2;
            int nonPick = prev1;

            int curr = Math.max(pick, nonPick);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}