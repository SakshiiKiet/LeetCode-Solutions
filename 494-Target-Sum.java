class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return solve(n-1,0,nums,target);
    }
    int solve(int i,int sum,int[] nums, int target){
        if(i==0){
            int ways=0;
            if(sum+nums[0]==target) ways++;
            if(sum-nums[0]==target) ways++;
            return ways;
        }
        int p=solve(i-1,sum+nums[i],nums,target);
        int m=solve(i-1,sum-nums[i],nums,target);
        return p+m;
    }
}