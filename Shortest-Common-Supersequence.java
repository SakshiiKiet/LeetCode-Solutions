1class Solution {
2    public String shortestCommonSupersequence(String str1, String str2) {
3
4        int m = str1.length();
5        int n = str2.length();
6
7        // Step 1: Build LCS DP table
8        int[][] dp = new int[m + 1][n + 1];
9
10        for (int i = 1; i <= m; i++) {
11            for (int j = 1; j <= n; j++) {
12                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
13                    dp[i][j] = 1 + dp[i - 1][j - 1];
14                } else {
15                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
16                }
17            }
18        }
19
20        // Step 2: Backtrack to build SCS
21        StringBuilder ans = new StringBuilder();
22        int i = m, j = n;
23
24        while (i > 0 && j > 0) {
25            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
26                ans.append(str1.charAt(i - 1));
27                i--;
28                j--;
29            } else if (dp[i - 1][j] > dp[i][j - 1]) {
30                ans.append(str1.charAt(i - 1));
31                i--;
32            } else {
33                ans.append(str2.charAt(j - 1));
34                j--;
35            }
36        }
37
38        // Step 3: Add remaining characters
39        while (i > 0) {
40            ans.append(str1.charAt(i - 1));
41            i--;
42        }
43        while (j > 0) {
44            ans.append(str2.charAt(j - 1));
45            j--;
46        }
47
48        return ans.reverse().toString();
49    }
50}