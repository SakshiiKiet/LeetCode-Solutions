class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        int n=coins.length;
        dp=new int[n][amount+1];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
        return solve(n-1,amount,coins);
    }
    int solve(int i,int amount,int[] coins){
        if(i==0){
            if(amount%coins[i]==0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        int not=solve(i-1,amount,coins);
        int take=0;
        if(amount>=coins[i]){
            take=solve(i,amount-coins[i],coins);
        }
        return dp[i][amount]=take+not;
    }
}