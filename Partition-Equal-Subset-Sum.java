1class Solution {
2    static Boolean[][] dp;
3    public boolean canPartition(int[] nums) {
4        int n=nums.length;
5        int totsum=0;
6        for(int i=0;i<n;i++){
7             totsum+=nums[i];
8        }
9        if(totsum%2!=0) return false;
10        int target=totsum/2;
11        dp = new Boolean[n][target + 1];
12        return subset(n-1,target,nums);
13    }
14    static boolean subset(int i, int sum, int arr[]) {
15        if (sum == 0) return true;
16        if (i == 0) return arr[0] == sum;
17
18        if (dp[i][sum] != null) return dp[i][sum];
19
20        boolean notTake = subset(i - 1, sum, arr);
21        boolean take = false;
22
23        if (sum >= arr[i]) {
24            take = subset(i - 1, sum - arr[i], arr);
25        }
26
27        return dp[i][sum] = notTake || take;
28    }
29}