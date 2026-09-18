class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];
       for(int prev=0;prev<=n;prev++){
        dp[n][prev]=0;
       }
       for(int i=n-1;i>=0;i--){
        for(int prev=i-1;prev>=-1;prev--){
           int not=dp[i+1][prev+1];
        int take=0;
        if(prev==-1 || nums[i]>nums[prev]){
            take=1+dp[i+1][i+1];
        }
        dp[i][prev+1]=Math.max(take,not);
        }
       }
        return dp[0][0];
    }
}