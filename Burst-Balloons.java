1class Solution {
2    public int maxCoins(int[] nums) {
3
4        int n = nums.length;
5        int[] arr = new int[n + 2];
6        arr[0] = 1;
7        arr[n + 1] = 1;
8
9        for (int i = 0; i < n; i++) {
10            arr[i + 1] = nums[i];
11        }
12
13        int[][] dp = new int[n + 2][n + 2];
14
15        // fill dp bottom up
16        for (int i = n; i >= 1; i--) {
17            for (int j = 1; j <= n; j++) {
18
19                if (i > j) continue;
20
21                int max = 0;
22
23                for (int k = i; k <= j; k++) {
24
25                    int cost =
26                            arr[i - 1] * arr[k] * arr[j + 1]
27                            + dp[i][k - 1]
28                            + dp[k + 1][j];
29
30                    max = Math.max(max, cost);
31                }
32
33                dp[i][j] = max;
34            }
35        }
36
37        return dp[1][n];
38    }
39}