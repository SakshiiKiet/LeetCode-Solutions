1class Solution {
2    public int numIslands(char[][] grid) {
3         int m = grid.length;
4        int n = grid[0].length;
5        int[][] vis=new int[m][n];
6        int[] drow={-1,0,+1,0};
7        int[] dcol={0,+1,0,-1};
8        int c=0;
9        for(int i=0;i<m;i++){
10            for(int j=0;j<n;j++){
11                if(vis[i][j]==0 && grid[i][j]=='1'){
12                    c++;
13                    dfs(i,j,grid,vis,drow,dcol);
14                }
15            }
16        }
17        return c;
18    }
19    void dfs(int row,int col,char[][] grid,int[][] vis,int[] drow,int[] dcol){
20        int m = grid.length;
21        int n = grid[0].length;
22        vis[row][col]=1;
23        for(int i=0;i<4;i++){
24            int nrow=row+drow[i];
25            int ncol=col+dcol[i];
26            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
27             dfs(nrow,ncol,grid,vis,drow,dcol);
28            }
29        }
30    }
31}