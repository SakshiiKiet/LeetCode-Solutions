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
22                    vis[i][j]=2; //if rotten
23                }else{
24                    vis[i][j]=0; // if not rotten
25                }
26                if(grid[i][j]==1) cntFresh++;
27            }
28        }
29        int time=0;
30        int drow[]={-1,0,+1,0};
31        int dcol[]={0,1,0,-1};
32        int cnt=0;
33        while(!q.isEmpty()){
34            int r=q.peek().row;
35            int c=q.peek().col;
36            int t=q.peek().time;
37            time=Math.max(time,t);
38            q.poll();
39            for(int i=0;i<4;i++){
40                int nrow=r+drow[i];
41                int ncol=c+dcol[i];
42                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1){
43                    q.offer(new Pair(nrow,ncol,t+1));
44                    vis[nrow][ncol]=2;
45                    cnt++;
46                }
47            }
48        }
49        if(cnt!=cntFresh) return -1;
50        return time;
51    }
52}