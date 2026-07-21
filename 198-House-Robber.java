class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums.length-1,nums);
    }
    int solve(int i, int[] nums){
        if(i==0) return nums[0];
        if(dp[i]!=-1) return dp[i];
        int nonpick=solve(i-1,nums);
        int pick=nums[i];
        if(i>1){
            pick+=solve(i-2,nums);
        }
        return dp[i]=Math.max(pick,nonpick);
    }
}