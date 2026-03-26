1class Pair {
2        int row;
3        int col;
4        Pair(int r, int c) {
5            row = r;
6            col = c;
7        }
8    }
9class Solution {
10    public int numEnclaves(int[][] grid) {
11         int m=grid.length;
12        int n=grid[0].length;
13        int[][] vis=new int[m][n];
14        int[] drow={-1,0,+1,0};
15        int[] dcol={0,+1,0,-1};
16        Queue<Pair>q=new LinkedList<>();
17        for(int i=0;i<m;i++){
18            for(int j=0;j<n;j++){
19                if(i==0 || j==0 || i==m-1 || j==n-1){
20                    if(grid[i][j]==1){
21                        q.offer(new Pair(i,j));
22                        vis[i][j]=1;
23                    }
24                }
25            }
26        }
27        while(!q.isEmpty()){
28            int row=q.peek().row;
29            int col=q.peek().col;
30            q.poll();
31            for(int i=0;i<4;i++){
32             int nrow=row+drow[i];
33             int ncol=col+dcol[i];
34             if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
35
36                    vis[nrow][ncol] = 1;
37                    q.offer(new Pair(nrow, ncol));
38                }
39            }
40        }
41        int c=0;
42        for(int i=0;i<m;i++){
43            for(int j=0;j<n;j++){
44                if(vis[i][j]==0 && grid[i][j]==1){
45                    c++;
46                }
47            }
48        }
49        return c;
50    }
51    
52}