1class Solution {
2    public int fib(int n) {
3        int[] dp=new int[n+1];
4        Arrays.fill(dp,-1);
5        if(n<=1) return n;
6        if(dp[n]!=-1) return dp[n];
7        return dp[n]=fib(n-1)+fib(n-2);
8    }
9}