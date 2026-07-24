class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n];
        int[]count=new int[n];
        int max=1;
        Arrays.fill(dp,1);
         Arrays.fill(count,1);
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[prev]<nums[i] && 1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                    count[i]=count[prev];
                }else if(nums[prev]<nums[i] && 1+dp[prev]==dp[i]){
                     count[i]+=count[prev];
                }
            }
            max=Math.max(max,dp[i]);
        }
       int c = 0;

        for(int i=0;i<n;i++){
            if(dp[i] == max){
                c += count[i];
            }
        }

        return c;
    }
}