1class Solution {
2    public int cherryPickup(int[][] grid) {
3
4        int n = grid.length;
5        int m = grid[0].length;
6
7        int[][][] dp = new int[n][m][m];
8
9        // Base case: last row
10        for (int j1 = 0; j1 < m; j1++) {
11            for (int j2 = 0; j2 < m; j2++) {
12                if (j1 == j2) {
13                    dp[n - 1][j1][j2] = grid[n - 1][j1];
14                } else {
15                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
16                }
17            }
18        }
19
20        // Fill DP table bottom-up
21        for (int i = n - 2; i >= 0; i--) {
22            for (int j1 = 0; j1 < m; j1++) {
23                for (int j2 = 0; j2 < m; j2++) {
24
25                    int max = Integer.MIN_VALUE;
26
27                    for (int dj1 = -1; dj1 <= 1; dj1++) {
28                        for (int dj2 = -1; dj2 <= 1; dj2++) {
29
30                            int nj1 = j1 + dj1;
31                            int nj2 = j2 + dj2;
32
33                            if (nj1 >= 0 && nj1 < m && nj2 >= 0 && nj2 < m) {
34
35                                int value;
36                                if (j1 == j2) {
37                                    value = grid[i][j1];
38                                } else {
39                                    value = grid[i][j1] + grid[i][j2];
40                                }
41
42                                value += dp[i + 1][nj1][nj2];
43                                max = Math.max(max, value);
44                            }
45                        }
46                    }
47
48                    dp[i][j1][j2] = max;
49                }
50            }
51        }
52
53        // Starting positions: robot1 at 0, robot2 at m-1
54        return dp[0][0][m - 1];
55    }
56}