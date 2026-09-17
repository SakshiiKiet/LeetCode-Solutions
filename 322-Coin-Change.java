class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        dp=new int[n][amount+1];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
       int ans= solve(n-1,amount,coins);
       return ans>=Integer.MAX_VALUE/2?-1:ans;
    }
    int solve(int i,int amount,int[] coins){
        if(i==0){
            if(amount%coins[i]==0){
                return amount/coins[i];
            }
            return Integer.MAX_VALUE/2;
        }
        if(amount==0) return 0;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int not=solve(i-1,amount,coins);
        int take=Integer.MAX_VALUE/2;
        if(amount>=coins[i]){
            take=1+solve(i,amount-coins[i],coins);
        }
        return dp[i][amount]= Math.min(not,take);
    }
}