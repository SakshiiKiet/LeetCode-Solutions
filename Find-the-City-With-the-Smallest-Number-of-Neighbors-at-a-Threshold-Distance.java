1class Solution {
2    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
3        int[][] dis=new int[n][n];
4        for(int i=0;i<n;i++){
5            for(int j=0;j<n;j++){
6                dis[i][j]=Integer.MAX_VALUE;
7            }
8        }
9        for(int i=0;i<edges.length;i++){
10            int u=edges[i][0];
11            int v=edges[i][1];
12            int wt=edges[i][2];
13            dis[u][v]=wt;
14            dis[v][u]=wt;
15        }
16        for(int i=0;i<n;i++){
17            dis[i][i]=0;
18        }
19        for(int k=0;k<n;k++){
20          for(int i=0;i<n;i++){
21            for(int j=0;j<n;j++){
22              if(dis[i][k]==Integer.MAX_VALUE || dis[k][j]==Integer.MAX_VALUE) continue;
23              dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
24                }
25            }
26        }
27        int cityno=-1;
28        int cmax=n;
29        for(int city=0;city<n;city++){
30            int c=0;
31            for(int adjcity=0;adjcity<n;adjcity++){
32                if(dis[city][adjcity]<=distanceThreshold){
33                    c++;
34                }
35            }
36             if(c <= cmax){
37                cmax = c;
38                cityno = city;
39            }
40        }
41        return cityno;
42    }
43}