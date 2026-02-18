1import java.util.*;
2
3class Solution {
4    public int rob(int[] nums) {
5        int n = nums.length;
6        if (n == 1) return nums[0];
7
8        // Case 1: Exclude first house
9        int[] arr1 = Arrays.copyOfRange(nums, 1, n);
10
11        // Case 2: Exclude last house
12        int[] arr2 = Arrays.copyOfRange(nums, 0, n - 1);
13
14        return Math.max(robber(arr1), robber(arr2));
15    }
16
17    // Space optimized House Robber I
18    public int robber(int[] nums) {
19        int prev2 = 0;
20        int prev1 = nums[0];
21
22        for (int i = 1; i < nums.length; i++) {
23            int pick = nums[i] + prev2;
24            int nonPick = prev1;
25
26            int curr = Math.max(pick, nonPick);
27
28            prev2 = prev1;
29            prev1 = curr;
30        }
31        return prev1;
32    }
33}
34