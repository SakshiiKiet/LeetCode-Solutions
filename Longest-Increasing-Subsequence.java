1class Solution {
2    public int lengthOfLIS(int[] nums) {
3        int n=nums.length;
4        int[][] dp=new int[n+1][n+1];
5        for(int prev=0;prev<=n;prev++){
6            dp[n][prev]=0;
7        }
8        for(int i=n-1;i>=0;i--){
9            for(int prev=i-1;prev>=-1;prev--){
10              int notTake=0+dp[i+1][prev+1]; 
11        int take=0;
12        if(prev==-1 || nums[i]>nums[prev]){
13             take=1+dp[i+1][i+1]; 
14        }
15         dp[i][prev+1]=Math.max(take,notTake);
16            }
17        }
18        return dp[0][0];
19    }
20}