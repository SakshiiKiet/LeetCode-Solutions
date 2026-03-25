1class Pair{
2    int row;
3    int col;
4    int step;
5    Pair(int row,int col,int step){
6        this.row=row;
7        this.col=col;
8        this.step=step;
9    }
10}
11class Solution {
12    public int[][] updateMatrix(int[][] mat) {
13        int m=mat.length;
14        int n=mat[0].length;
15        int[][] vis=new int[m][n];
16        int[][] dis=new int[m][n];
17        Queue<Pair>q=new LinkedList<>();
18        for(int i=0;i<m;i++){
19            for(int j=0;j<n;j++){
20                if(mat[i][j]==0){
21                    q.offer(new Pair(i,j,0));
22                    vis[i][j]=1;
23                }else{
24                    vis[i][j]=0;
25                }
26            }
27        }
28        int[] drow={-1,0,+1,0};
29        int[] dcol={0,+1,0,-1};
30        while(!q.isEmpty()){
31            int row=q.peek().row;
32            int col=q.peek().col;
33            int step=q.peek().step;
34            q.poll();
35            dis[row][col]=step;
36            for(int i=0;i<4;i++){
37                int nrow=row+drow[i];
38                int ncol=col+dcol[i];
39                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]==0 ){
40                    vis[nrow][ncol]=1;
41                    q.offer(new Pair(nrow,ncol,step+1));
42                }
43            }
44        }
45        return dis;
46    }
47}