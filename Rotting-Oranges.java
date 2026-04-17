1class Pair{
2    int row;
3    int col;
4    int time;
5    Pair(int row,int col,int time){
6        this.row=row;
7        this.col=col;
8        this.time=time;
9    }
10}
11class Solution {
12    public int orangesRotting(int[][] grid) {
13        int m=grid.length;
14        int n=grid[0].length;
15        Queue<Pair>q=new LinkedList<>();
16        int[][] vis=new int[m][n];
17        int cntFresh=0;
18        for(int i=0;i<m;i++){
19            for(int j=0;j<n;j++){
20                if(grid[i][j]==2){
21                    q.offer(new Pair(i,j,0));
22                    vis[i][j]=2;
23                }else{
24                    vis[i][j]=0;
25                }
26                if(grid[i][j]==1){
27                    cntFresh++;
28                }
29            }
30        }
31        int cnt=0;
32        int time=0;
33        int drow[]={-1,0,+1,0};
34        int dcol[]={0,+1,0,-1};
35        while(!q.isEmpty()){
36            int r=q.peek().row;
37            int c=q.peek().col;
38            int t=q.peek().time;
39             time=Math.max(time,t);
40            q.poll();
41            for(int i=0;i<4;i++){
42                int nrow=r+drow[i];
43                int ncol=c+dcol[i];
44                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
45                    q.offer(new Pair(nrow,ncol,t+1));
46                    vis[nrow][ncol]=2;
47                    cnt++;
48                }
49            }
50        }
51      if(cnt!=cntFresh) return -1;
52      return time;
53    }
54}