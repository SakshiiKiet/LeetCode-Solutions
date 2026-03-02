1class Solution {
2    Boolean[][] dp;
3
4    public boolean isMatch(String s, String p) {
5        int n = s.length();
6        int m = p.length();
7        dp = new Boolean[m+1][n+1];   // dp[i][j] → pattern i, string j
8        return f(m , n, s, p);
9    }
10
11    boolean f(int i, int j, String s, String p) {
12
13        // Base cases
14        if (i ==0 && j == 0) return true;
15        if (i == 0 && j > 0) return false;
16
17        if (j ==0  && i > 0) {
18            for (int ii = 1; ii <= i; ii++) {
19                if (p.charAt(ii-1) != '*') return false;
20            }
21            return true;
22        }
23
24        // Memoization check
25        if (dp[i][j] != null) return dp[i][j];
26
27        // Match or '?'
28        if ( p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?') {
29           return dp[i][j] = f(i - 1, j - 1, s, p);
30        }
31        // '*'
32         if (p.charAt(i-1) == '*') {
33           return dp[i][j] = f(i - 1, j, s, p)   // '*' matches empty
34               || f(i, j - 1, s, p);  // '*' matches one or more chars
35        }
36        // No match
37        return dp[i][j] = false;
38    }
39}