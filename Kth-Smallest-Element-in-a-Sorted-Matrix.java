1class Solution {
2
3    static class Pair {
4        int value;
5        int row;
6        int col;
7
8        Pair(int value, int row, int col) {
9            this.value = value;
10            this.row = row;
11            this.col = col;
12        }
13    }
14
15    public int kthSmallest(int[][] matrix, int k) {
16
17        int n = matrix.length;
18
19        // Min Heap based on value
20        PriorityQueue<Pair> pq =
21                new PriorityQueue<>((a, b) -> a.value - b.value);
22
23        // Insert first element of every row
24        for (int i = 0; i < n; i++) {
25            pq.add(new Pair(matrix[i][0], i, 0));
26        }
27
28        int ans = 0;
29
30        while (k > 0) {
31
32            Pair current = pq.poll();
33            ans = current.value;
34
35            int r = current.row;
36            int c = current.col;
37
38            // If next column exists
39            if (c + 1 < n) {
40                pq.add(new Pair(matrix[r][c + 1], r, c + 1));
41            }
42            k--;
43        }
44
45        return ans;
46    }
47}
48