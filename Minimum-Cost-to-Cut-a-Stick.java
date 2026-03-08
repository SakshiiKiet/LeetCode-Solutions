1class Solution {
2
3    public int minCost(int n, int[] cuts) {
4
5        int c = cuts.length;
6
7        List<Integer> cut = new ArrayList<>();
8        for (int x : cuts) {
9            cut.add(x);
10        }
11
12        cut.add(n);
13        cut.add(0, 0);
14        Collections.sort(cut);
15
16        int[][] dp = new int[c + 2][c + 2];
17
18        for (int i = c; i >= 1; i--) {
19            for (int j = 1; j <= c; j++) {
20
21                if (i > j) continue;
22
23                int min = Integer.MAX_VALUE;
24
25                for (int ind = i; ind <= j; ind++) {
26
27                    int cost = cut.get(j + 1) - cut.get(i - 1)
28                            + dp[i][ind - 1]
29                            + dp[ind + 1][j];
30
31                    min = Math.min(min, cost);
32                }
33
34                dp[i][j] = min;
35            }
36        }
37
38        return dp[1][c];
39    }
40}