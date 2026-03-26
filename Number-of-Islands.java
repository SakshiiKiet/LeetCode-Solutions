1class Pair {
2        int row;
3        int col;
4        Pair(int r, int c) {
5            row = r;
6            col = c;
7        }
8    }
9class Solution {
10    public int numIslands(char[][] grid) {
11         int m = grid.length;
12        int n = grid[0].length;
13        int[][] vis=new int[m][n];
14        int[] drow={-1,0,+1,0};
15        int[] dcol={0,+1,0,-1};
16        Queue<Pair>q=new LinkedList<>();
17        int c=0;
18        for(int i=0;i<m;i++){
19         for(int j=0;j<n;j++){
20          if(vis[i][j]==0 && grid[i][j]=='1'){
21            c++;
22            q.offer(new Pair(i,j));
23            vis[i][j]=1;
24            while(!q.isEmpty()){
25              int row=q.peek().row;
26              int col=q.peek().col;
27              q.poll();
28                for(int k=0;k<4;k++){
29                int nrow=row+drow[k];
30                int ncol=col+dcol[k];
31                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1') {
32
33                    vis[nrow][ncol] = 1;
34                    q.offer(new Pair(nrow, ncol));
35                  }
36                }
37              }
38            }
39          }     
40        }
41        return c;
42    }
43}