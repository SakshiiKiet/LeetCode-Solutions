1class Solution {
2    int[] dp;
3    int minCut(String s) {
4        int n=s.length();
5        dp=new int[n];
6        Arrays.fill(dp,-1);
7        return solve(0, s) - 1; // cuts = partitions - 1
8    }
9
10    int solve(int index, String s) {
11        if (index == s.length()) return 0;
12        if(dp[index]!=-1) return dp[index];
13        int min = Integer.MAX_VALUE;
14
15        for (int i = index; i < s.length(); i++) {
16            if (isPalindrome(s, index, i)) {
17                min = Math.min(min, 1 + solve(i + 1, s));
18            }
19        }
20        return dp[index]=min;
21    }
22
23    boolean isPalindrome(String s, int l, int r) {
24        while (l < r) {
25            if (s.charAt(l++) != s.charAt(r--)) return false;
26        }
27        return true;
28    }
29}
30