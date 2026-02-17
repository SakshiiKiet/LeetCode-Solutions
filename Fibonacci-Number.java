1class Solution {
2    public int fib(int n) {
3        if(n<=1) return n;
4        int[] dp=new int[n+1];
5        dp[0]=0;
6        dp[1]=1;
7        
8        for(int i=2;i<=n;i++){
9            dp[i]=dp[i-1]+dp[i-2];
10        }
11        return dp[n];
12    }
13}