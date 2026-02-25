1class Solution {
2    int[][] dp;
3    public int coinChange(int[] coins, int amount) {
4        int n=coins.length;
5        dp=new int[n][amount+1];
6        for(int[] rows:dp){
7            Arrays.fill(rows,-1);
8        }
9        int ans= coin(n-1,amount,coins);
10        return ans>=Integer.MAX_VALUE/2?-1:ans;
11    }
12    int coin(int i,int target,int[] coins){
13        if(i==0){
14            if(target%coins[i]==0){
15                return target/coins[i];
16            }else{
17                return Integer.MAX_VALUE/2;
18            }
19        }
20        if(target==0) return 0;
21        if(dp[i][target]!=-1) return dp[i][target];
22        int notTake=0+coin(i-1,target,coins);
23        int Take=Integer.MAX_VALUE/2;
24        if(target>=coins[i]){
25            Take=1+coin(i,target-coins[i],coins);
26        }  
27       return dp[i][target]=Math.min(Take,notTake);
28    }
29}