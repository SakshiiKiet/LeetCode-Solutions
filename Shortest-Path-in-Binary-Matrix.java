1import java.util.*;
2
3class Solution {
4    public int shortestPathBinaryMatrix(int[][] grid) {
5
6        int n = grid.length;
7
8        //  start or end blocked
9        if(grid[0][0] != 0 || grid[n-1][n-1] != 0){
10            return -1;
11        }
12
13        // distance matrix
14        int[][] dist = new int[n][n];
15        for(int i = 0; i < n; i++){
16            Arrays.fill(dist[i], (int)1e9);
17        }
18
19        // 8 directions
20        int[] dr = {-1,-1,-1,0,0,1,1,1};
21        int[] dc = {-1,0,1,-1,1,-1,0,1};
22
23        Queue<int[]> q = new LinkedList<>();
24
25        // start from (0,0)
26        q.add(new int[]{1, 0, 0}); // {distance, row, col}
27        dist[0][0] = 1;
28
29        while(!q.isEmpty()){
30            int[] curr = q.poll();
31
32            int dis = curr[0];
33            int r = curr[1];
34            int c = curr[2];
35
36            //  reached destination
37            if(r == n-1 && c == n-1){
38                return dis;
39            }
40
41            // explore 8 directions
42            for(int i = 0; i < 8; i++){
43                int nr = r + dr[i];
44                int nc = c + dc[i];
45
46                if(nr >= 0 && nr < n && nc >= 0 && nc < n
47                   && grid[nr][nc] == 0
48                   && dis + 1 < dist[nr][nc]){
49
50                    dist[nr][nc] = dis + 1;
51                    q.add(new int[]{dis + 1, nr, nc});
52                }
53            }
54        }
55
56        return -1;
57    }
58}