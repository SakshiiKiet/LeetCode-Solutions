1class Solution {
2    public int lengthOfLIS(int[] nums) {
3        int n=nums.length;
4        int[]dp=new int[n];
5        int max=1;
6        Arrays.fill(dp,1);
7        for(int i=0;i<n;i++){
8            for(int prev=0;prev<i;prev++){
9                if(nums[prev]<nums[i]){
10                    dp[i]=Math.max(dp[i],1+dp[prev]);
11                }
12            }
13            max=Math.max(max,dp[i]);
14        }
15        return max;
16    }
17}