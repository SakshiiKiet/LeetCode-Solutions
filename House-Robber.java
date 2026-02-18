1class Solution {
2     public int rob(int[] nums) {
3      int n = nums.length;
4        
5        if (n == 0) return 0;
6        if (n == 1) return nums[0];
7
8        int[] dp = new int[n];
9        dp[0] = nums[0];
10        for(int i=1;i<n;i++){
11        int pick=nums[i];
12        if(i>1){
13         pick+=dp[i-2];
14        }
15        int nonpick=0+dp[i-1];
16        dp[i]=Math.max(pick,nonpick);
17        }
18        return dp[n-1];
19     }
20}