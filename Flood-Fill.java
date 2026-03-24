1class Pair {
2    int row, col;
3    Pair(int row, int col){
4        this.row = row;
5        this.col = col;
6    }
7}
8
9class Solution {
10    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
11
12        int m = image.length;
13        int n = image[0].length;
14
15        int initial = image[sr][sc];
16        if(initial == color) return image;
17
18        Queue<Pair> q = new LinkedList<>();
19        q.offer(new Pair(sr, sc));
20
21        image[sr][sc] = color;
22
23        int[] drow = {-1,0,1,0};
24        int[] dcol = {0,1,0,-1};
25
26        while(!q.isEmpty()){
27            Pair p = q.poll();
28            int r = p.row;
29            int c = p.col;
30
31            for(int i = 0; i < 4; i++){
32                int nrow = r + drow[i];
33                int ncol = c + dcol[i];
34
35                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
36                   && image[nrow][ncol] == initial){
37
38                    image[nrow][ncol] = color;
39                    q.offer(new Pair(nrow, ncol));
40                }
41            }
42        }
43        return image;
44    }
45}