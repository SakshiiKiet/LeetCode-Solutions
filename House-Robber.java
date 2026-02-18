1class Solution {
2    int[]  dp;
3     public int rob(int[] nums) {
4        dp=new int[nums.length];
5        Arrays.fill(dp,-1);
6     return robber(nums.length-1,nums);
7}
8int robber(int idx,int[] nums){
9    if(idx==0) return nums[0];
10    if(idx<0) return 0;
11     if(dp[idx]!=-1) return dp[idx];
12    int pick=nums[idx]+robber(idx-2,nums);
13    int nonpick=0+robber(idx-1,nums);
14    return dp[idx]=Math.max(pick,nonpick);
15}
16}