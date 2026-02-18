1class Solution {
2    public int rob(int[] nums) {
3        int n = nums.length;
4
5        if (n == 0) return 0;
6        if (n == 1) return nums[0];
7
8        int prev2 = 0;        // dp[i-2]
9        int prev1 = nums[0]; // dp[i-1]
10
11        for (int i = 1; i < n; i++) {
12            int pick = nums[i] + prev2;
13            int nonPick = prev1;
14
15            int curr = Math.max(pick, nonPick);
16
17            prev2 = prev1;
18            prev1 = curr;
19        }
20
21        return prev1;
22    }
23}
24