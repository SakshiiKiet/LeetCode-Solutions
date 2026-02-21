1class Solution {
2    public int uniquePaths(int m, int n) {
3
4        int[] prev = new int[n];
5
6        for (int i = 0; i < m; i++) {
7
8            int[] temp = new int[n];
9
10            for (int j = 0; j < n; j++) {
11
12                if (i == 0 && j == 0) {
13                    temp[j] = 1;
14                } else {
15                    int up = (i > 0) ? prev[j] : 0;
16                    int left = (j > 0) ? temp[j - 1] : 0;
17
18                    temp[j] = up + left;
19                }
20            }
21
22            prev = temp;
23        }
24
25        return prev[n - 1];
26    }
27}