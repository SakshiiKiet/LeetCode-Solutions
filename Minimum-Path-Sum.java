1class Solution {
2    int[][] dp;
3
4    public int minPathSum(int[][] grid) {
5        int m = grid.length;
6        int n = grid[0].length;
7        dp = new int[m][n];
8        for (int[] row : dp) Arrays.fill(row, -1);
9        return path(m - 1, n - 1, grid);
10    }
11
12    int path(int i, int j, int[][] grid) {
13        if (i == 0 && j == 0) return grid[0][0];
14        if (i < 0 || j < 0) return Integer.MAX_VALUE / 2;
15        if (dp[i][j] != -1) return dp[i][j];
16
17        int up = grid[i][j] + path(i - 1, j, grid);
18        int left = grid[i][j] + path(i, j - 1, grid);
19
20        return dp[i][j] = Math.min(up, left);
21    }
22}