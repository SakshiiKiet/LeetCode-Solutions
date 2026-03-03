1class Solution {
2    int[][]dp;
3    public int lengthOfLIS(int[] nums) {
4        int n=nums.length;
5        dp=new int[n][n+1];
6        for(int[] row : dp) {
7            Arrays.fill(row, -1);
8        }
9        return length(0,-1,nums);
10    }
11    int length(int i,int pre_ind,int[] nums){
12        if(i==nums.length) return 0;
13        if(dp[i][pre_ind+1]!=-1) return dp[i][pre_ind+1];
14        int notTake=0+length(i+1,pre_ind,nums); 
15        int take=0;
16        if(pre_ind==-1 || nums[i]>nums[pre_ind]){
17             take=1+length(i+1,i,nums); 
18        }
19        return dp[i][pre_ind+1]=Math.max(take,notTake);
20    }
21}