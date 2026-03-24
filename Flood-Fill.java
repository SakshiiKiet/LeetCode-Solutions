1class Pair {
2    int row, col;
3    Pair(int row, int col){
4        this.row = row;
5        this.col = col;
6    }
7}
8class Solution {
9    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
10        int m=image.length;
11        int n=image[0].length;
12        int initial=image[sr][sc];
13        if(initial==color) return image;
14        int[][] vis=image;
15        Queue<Pair>q=new LinkedList<>();
16        q.offer(new Pair(sr,sc));
17        vis[sr][sc]=color;
18        int drow[]={-1,0,+1,0};
19        int dcol[]={0,1,0,-1};
20        while(!q.isEmpty()){
21            int r=q.peek().row;
22            int c=q.peek().col;
23            q.poll();
24         for(int i=0;i<4;i++){
25            int nrow=r+drow[i];
26            int ncol=c+dcol[i];
27            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && image[nrow][ncol]==initial && vis[nrow][ncol]!=color){
28                q.offer(new Pair(nrow,ncol));
29                vis[nrow][ncol]=color;
30            }
31         }
32        }
33     return vis;
34    }
35}