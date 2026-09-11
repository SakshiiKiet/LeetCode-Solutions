class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
        int not=dp[i-1];
        int pick=nums[i];
        if(i>1){
            pick+=dp[i-2];
        }
        dp[i]=Math.max(pick,not);
        }
        return dp[nums.length-1];
    }
}