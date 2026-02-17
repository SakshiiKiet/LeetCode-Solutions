1class Solution {
2    int[] dp;
3
4    public int fib(int n) {
5        dp = new int[n + 1];
6        Arrays.fill(dp, -1);
7        return solve(n);
8    }
9
10    private int solve(int n) {
11        if (n <= 1) return n;
12
13        if (dp[n] != -1) return dp[n];
14
15        dp[n] = solve(n - 1) + solve(n - 2);
16        return dp[n];
17    }
18}
19