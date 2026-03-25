1class Solution {
2
3    static class Pair {
4        int row;
5        int col;
6        Pair(int r, int c) {
7            row = r;
8            col = c;
9        }
10    }
11
12    public void solve(char[][] board) {
13        int m = board.length;
14        int n = board[0].length;
15
16        int[][] vis = new int[m][n];
17        int[] drow = {-1, 0, 1, 0};
18        int[] dcol = {0, 1, 0, -1};
19
20        Queue<Pair> q = new LinkedList<>();
21        for(int j = 0; j < n; j++) {
22            if (board[0][j] == 'O') {
23                q.offer(new Pair(0, j));
24                vis[0][j] = 1;
25            }
26            if (board[m - 1][j] == 'O') {
27                q.offer(new Pair(m - 1, j));
28                vis[m - 1][j] = 1;
29            }
30        }
31
32        for (int i = 0; i < m; i++) {
33            if (board[i][0] == 'O') {
34                q.offer(new Pair(i, 0));
35                vis[i][0] = 1;
36            }
37            if (board[i][n - 1] == 'O') {
38                q.offer(new Pair(i, n - 1));
39                vis[i][n - 1] = 1;
40            }
41        }
42        while (!q.isEmpty()) {
43            Pair cur = q.poll();
44
45            for (int i = 0; i < 4; i++) {
46                int nrow = cur.row + drow[i];
47                int ncol = cur.col + dcol[i];
48
49                if (nrow >= 0 && nrow < m &&
50                    ncol >= 0 && ncol < n &&
51                    vis[nrow][ncol] == 0 &&
52                    board[nrow][ncol] == 'O') {
53
54                    vis[nrow][ncol] = 1;
55                    q.offer(new Pair(nrow, ncol));
56                }
57            }
58        }
59
60        for (int i = 0; i < m; i++) {
61            for (int j = 0; j < n; j++) {
62                if (vis[i][j] == 0 && board[i][j] == 'O') {
63                    board[i][j] = 'X';
64                }
65            }
66        }
67    }
68    }
69