class Solution {
    int[][]dp;
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        dp=new int[n][n+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return length(0,-1,nums);
    }
    int length(int i,int pre_ind,int[] nums){
        if(i==nums.length) return 0;
        if(dp[i][pre_ind+1]!=-1) return dp[i][pre_ind+1];
        int notTake=0+length(i+1,pre_ind,nums); 
        int take=0;
        if(pre_ind==-1 || nums[i]>nums[pre_ind]){
             take=1+length(i+1,i,nums); 
        }
        return dp[i][pre_ind+1]=Math.max(take,notTake);
    }
}