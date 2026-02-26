1class Solution {
2    public int findTargetSumWays(int[] nums, int target) {
3        return count(nums.length - 1, 0, target, nums);
4    }
5
6    int count(int i, int sum, int target, int[] nums) {
7        if (i == 0) {
8            int ways = 0;
9            if (sum + nums[0] == target) ways++;
10            if (sum - nums[0] == target) ways++;
11            return ways;
12        }
13
14        int plus = count(i - 1, sum + nums[i], target, nums);
15        int minus = count(i - 1, sum - nums[i], target, nums);
16
17        return plus + minus;
18    }
19}
20
21