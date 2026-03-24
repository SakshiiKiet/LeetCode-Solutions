1class Solution {
2    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
3        int initial=image[sr][sc];
4         if(initial==color) return image;
5        int[][] vis=image;
6        int[] drow={-1,0,1,0};
7        int[] dcol={0,1,0,-1};
8        dfs(sr,sc,color,initial,image,vis,drow,dcol);
9        return vis;
10    }
11    void dfs(int row,int col,int newcolor,int initialcolor,int[][] image,int[][] vis,int[] drow,int[] dcol){
12       vis[row][col]=newcolor;
13       int m=image.length;
14       int n=image[0].length;
15       for(int i=0;i<4;i++){
16         int nrow = row + drow[i];
17            int ncol = col + dcol[i];
18
19        if(nrow >= 0 && nrow < m &&ncol >= 0 && ncol < n &&image[nrow][ncol] == initialcolor && vis[nrow][ncol] != newcolor) {
20
21                dfs(nrow, ncol,newcolor,initialcolor,image,vis,drow,dcol);
22            }
23       }
24    }
25}