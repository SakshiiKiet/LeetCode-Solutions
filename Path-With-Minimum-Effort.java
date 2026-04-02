1class Pair {
2    int diff, row, col;
3
4    Pair(int diff, int row, int col){
5        this.diff = diff;
6        this.row = row;
7        this.col = col;
8    }
9}
10
11class Solution {
12    public int minimumEffortPath(int[][] heights) {
13
14        int n = heights.length;
15        int m = heights[0].length;
16
17        // min heap based on effort
18        PriorityQueue<Pair> pq = new PriorityQueue<>(
19            (a, b) -> a.diff - b.diff
20        );
21
22        int[][] dist = new int[n][m];
23        for(int i = 0; i < n; i++){
24            Arrays.fill(dist[i], (int)1e9);
25        }
26
27        dist[0][0] = 0;
28        pq.add(new Pair(0, 0, 0));
29
30        // 4 directions
31        int[] dr = {-1, 0, 1, 0};
32        int[] dc = {0, 1, 0, -1};
33
34        while(!pq.isEmpty()){
35            Pair curr = pq.poll();
36
37            int diff = curr.diff;
38            int row = curr.row;
39            int col = curr.col;
40
41            // reached destination
42            if(row == n-1 && col == m-1){
43                return diff;
44            }
45
46            for(int i = 0; i < 4; i++){
47                int newr = row + dr[i];
48                int newc = col + dc[i];
49
50                if(newr >= 0 && newc >= 0 && newr < n && newc < m){
51
52                    int newEffort = Math.max(
53                        Math.abs(heights[row][col] - heights[newr][newc]),
54                        diff
55                    );
56
57                    if(newEffort < dist[newr][newc]){
58                        dist[newr][newc] = newEffort;
59                        pq.add(new Pair(newEffort, newr, newc));
60                    }
61                }
62            }
63        }
64
65        return 0; // fallback (won't happen normally)
66    }
67}