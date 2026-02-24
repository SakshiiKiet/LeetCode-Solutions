1class Solution {
2    public boolean canPartition(int[] nums) {
3        int n = nums.length;
4        int totalSum = 0;
5
6        for (int i=0;i<n;i++) {
7            totalSum += nums[i];
8        }
9
10        // If total sum is odd, cannot partition
11        if (totalSum % 2 != 0) return false;
12
13        int target = totalSum / 2;
14
15        boolean[] prev = new boolean[target + 1];
16
17        // base case: sum = 0
18        prev[0] = true;
19
20        // first element
21        if (nums[0] <= target) {
22            prev[nums[0]] = true;
23        }
24
25        for (int i = 1; i < n; i++) {
26            boolean[] curr = new boolean[target + 1];
27            curr[0] = true;
28
29            for (int j = 1; j <= target; j++) {
30                boolean notTake = prev[j];
31                boolean take = false;
32
33                if (j >= nums[i]) {
34                    take = prev[j - nums[i]];
35                }
36
37                curr[j] = notTake || take;
38            }
39
40            prev = curr;
41        }
42
43        return prev[target];
44    }
45}