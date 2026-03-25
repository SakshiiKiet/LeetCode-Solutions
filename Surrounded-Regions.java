1class Solution {
2    public void solve(char[][] board) {
3        int m=board.length;
4        int n=board[0].length;
5        int[][] vis=new int[m][n];
6        int[] drow={-1,0,+1,0};
7        int[] dcol={0,+1,0,-1};
8        for(int j=0;j<n;j++){
9            //first row
10            if(vis[0][j]==0 && board[0][j]=='O'){
11                dfs(0,j,board,vis,drow,dcol);
12            }
13
14            //last row
15            if(vis[m-1][j]==0 && board[m-1][j]=='O'){
16                dfs(m-1,j,board,vis,drow,dcol);
17            }
18        }
19        for(int i=0;i<m;i++){
20            //first col
21            if(vis[i][0]==0 && board[i][0]=='O'){
22                dfs(i,0,board,vis,drow,dcol);
23            }
24
25            //last col
26            if(vis[i][n-1]==0 && board[i][n-1]=='O'){
27                dfs(i,n-1,board,vis,drow,dcol);
28            }
29        }
30        for(int i=0;i<m;i++){
31            for(int j=0;j<n;j++){
32                if(vis[i][j]==0 && board[i][j]=='O'){
33                    board[i][j]='X';
34                }
35            }
36        }
37    }
38    void dfs(int row,int col,char[][] board,int[][] vis,int[] drow,int[] dcol){
39         int m=board.length;
40        int n=board[0].length;
41        vis[row][col]=1;
42        for(int i=0;i<4;i++){
43            int nrow=row+drow[i];
44            int ncol=col+dcol[i];
45            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
46             dfs(nrow,ncol,board,vis,drow,dcol);
47            }
48        }
49    }
50}