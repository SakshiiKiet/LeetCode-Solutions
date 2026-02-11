1class Solution {
2
3    static class Node {
4        int value;
5        int row;
6        int col;
7
8        Node(int value, int row, int col) {
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
20        PriorityQueue<Node> pq =
21                new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
22
23        // Push first element
24        pq.add(new Node(matrix[0][0], 0, 0));
25
26        // Mark visited
27        matrix[0][0] = -1;
28
29        int ans = 0;
30
31        while (k-- > 0) {
32
33            Node element = pq.poll();
34
35            ans = element.value;
36            int i = element.row;
37            int j = element.col;
38
39            // Down
40            if (i + 1 < n && matrix[i + 1][j] != -1) {
41                pq.add(new Node(matrix[i + 1][j], i + 1, j));
42                matrix[i + 1][j] = -1;
43            }
44
45            // Right
46            if (j + 1 < n && matrix[i][j + 1] != -1) {
47                pq.add(new Node(matrix[i][j + 1], i, j + 1));
48                matrix[i][j + 1] = -1;
49            }
50        }
51
52        return ans;
53    }
54}
55