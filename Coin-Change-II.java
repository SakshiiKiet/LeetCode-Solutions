1class Solution {
2    int[][]dp;
3    public int change(int amount, int[] coins) {
4        int n=coins.length;
5        dp=new int [n][amount+1];
6        for(int[] rows:dp){
7            Arrays.fill(rows,-1);
8        }
9        return count(n-1,amount,coins);
10        
11    }
12    int count(int i,int target,int[] nums){
13    if (i == 0) {
14    if (target % nums[0] == 0) {
15        return 1;
16    } else {
17        return 0;
18    }
19}
20        if(dp[i][target]!=-1) return dp[i][target];
21        int notTake=count(i-1,target,nums);
22        int take=0;
23        if(target>=nums[i]){
24            take=count(i,target-nums[i],nums);
25        }
26        return dp[i][target]=take+notTake;
27    }
28        }
29    