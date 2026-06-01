1class Solution {
2    public boolean canPartition(int[] nums) {
3        int n = nums.length;
4
5        int totalSum = 0;
6        for (int num : nums) {
7            totalSum += num;
8        }
9
10        // If total sum is odd, partition not possible
11        if (totalSum % 2 != 0) return false;
12
13        int target = totalSum / 2;
14
15        boolean[][] dp = new boolean[n][target + 1];
16
17        // Sum 0 is always possible
18        for (int i = 0; i < n; i++) {
19            dp[i][0] = true;
20        }
21
22        // First element handling
23        if (nums[0] <= target) {
24            dp[0][nums[0]] = true;
25        }
26
27        // Fill DP table
28        for (int i = 1; i < n; i++) {
29            for (int sum = 1; sum <= target; sum++) {
30
31                boolean notTake = dp[i - 1][sum];
32
33                boolean take = false;
34                if (sum >= nums[i]) {
35                    take = dp[i - 1][sum - nums[i]];
36                }
37
38                dp[i][sum] = take || notTake;
39            }
40        }
41
42        return dp[n - 1][target];
43    }
44}