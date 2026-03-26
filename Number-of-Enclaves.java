1class Solution {
2    public int numEnclaves(int[][] grid) {
3         int m=grid.length;
4        int n=grid[0].length;
5        int[][] vis=new int[m][n];
6        int[] drow={-1,0,+1,0};
7        int[] dcol={0,+1,0,-1};
8        for(int j=0;j<n;j++){
9            //first row
10            if(vis[0][j]==0 && grid[0][j]==1){
11                dfs(0,j,grid,vis,drow,dcol);
12            }
13
14            //last row
15            if(vis[m-1][j]==0 && grid[m-1][j]==1){
16                dfs(m-1,j,grid,vis,drow,dcol);
17            }
18        }
19        for(int i=0;i<m;i++){
20            //first col
21            if(vis[i][0]==0 && grid[i][0]==1){
22                dfs(i,0,grid,vis,drow,dcol);
23            }
24
25            //last col
26            if(vis[i][n-1]==0 && grid[i][n-1]==1){
27                dfs(i,n-1,grid,vis,drow,dcol);
28            }
29        }
30        int c=0;
31        for(int i=0;i<m;i++){
32            for(int j=0;j<n;j++){
33                if(vis[i][j]==0 && grid[i][j]==1){
34                    c++;
35                }
36            }
37        }
38        return c;
39    }
40    void dfs(int row,int col,int[][] grid,int[][] vis,int[] drow,int[] dcol){
41         int m=grid.length;
42        int n=grid[0].length;
43        vis[row][col]=1;
44        for(int i=0;i<4;i++){
45            int nrow=row+drow[i];
46            int ncol=col+dcol[i];
47            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
48             dfs(nrow,ncol,grid,vis,drow,dcol);
49            }
50        }
51    }
52}