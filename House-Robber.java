1class Solution {
2    public int rob(int[] nums) {
3        int n=nums.length;
4        if(n==0) return 0;
5        int[] dp=new int[n];
6        dp[0]=nums[0];
7        for(int i=1;i<n;i++){
8            int pick=nums[i];
9            if(i>1){
10                pick+=dp[i-2];
11            }
12            int nonpick=dp[i-1];
13            dp[i]=Math.max(pick,nonpick);
14        }
15        return dp[n-1];
16    }
17}