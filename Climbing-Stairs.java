1class Solution {
2    public int climbStairs(int n) {
3       int[] dp = new int[n + 1];
4        Arrays.fill(dp, -1);
5        if (n <= 1) return 1;
6
7        dp[0]=1;
8        dp[1]=1;
9        for(int i=2;i<=n;i++){
10            dp[i]=dp[i-1]+dp[i-2];
11        }
12        return dp[n];
13    }
14}
15