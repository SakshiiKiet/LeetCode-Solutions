1class Solution {
2    static class DisjointSet {
3        int[] parent, size;
4
5        DisjointSet(int n) {
6            parent = new int[n];
7            size = new int[n];
8
9            for (int i = 0; i < n; i++) {
10                parent[i] = i;
11                size[i] = 1;
12            }
13        }
14
15        int findPar(int node) {
16            if (node == parent[node])
17                return node;
18            return parent[node] = findPar(parent[node]);
19        }
20
21        void unionBySize(int u, int v) {
22            int pu = findPar(u);
23            int pv = findPar(v);
24
25            if (pu == pv) return;
26
27            if (size[pu] < size[pv]) {
28                parent[pu] = pv;
29                size[pv] += size[pu];
30            } else {
31                parent[pv] = pu;
32                size[pu] += size[pv];
33            }
34        }
35    }
36    boolean isValid(int nrow,int ncol,int n){
37        return nrow>=0 && nrow<n && ncol>=0 && ncol<n;
38    }
39    public int largestIsland(int[][] grid) {
40        int n=grid.length;
41        DisjointSet ds=new DisjointSet(n*n);
42        //Step-1 Connecting components
43        for(int row=0;row<n;row++){
44            for(int col=0;col<n;col++){
45              if(grid[row][col]==0) continue;
46              int[] dr={-1,0,1,0};
47              int[] dc={0,-1,0,1};
48              for(int i=0;i<4;i++){
49                int nrow=row+dr[i];
50                int ncol=col+dc[i];
51                if(isValid(nrow,ncol,n) && grid[nrow][ncol]==1){
52                    int nodeNo=row*n+col;
53                    int adjNodeNo=nrow*n+ncol;
54                    ds.unionBySize(nodeNo,adjNodeNo);
55                }
56              }
57            }
58        }
59        //Step-2
60        int max=0;
61        for(int row=0;row<n;row++){
62            for(int col=0;col<n;col++){
63              if(grid[row][col]==1) continue;
64              int[] dr={-1,0,1,0};
65              int[] dc={0,-1,0,1};
66              HashSet<Integer>components=new HashSet<>();
67              for(int i=0;i<4;i++){
68                int nrow=row+dr[i];
69                int ncol=col+dc[i];
70                if(isValid(nrow,ncol,n) && grid[nrow][ncol]==1){
71                    components.add(ds.findPar(nrow*n+ncol));
72                }
73              }
74               int totalsize=0;
75               for(Integer parents:components){
76                totalsize+=ds.size[parents];
77               }
78               max=Math.max(max,totalsize+1);
79            }
80        }
81        // if all cells are one
82        for(int i=0;i<n*n;i++){
83            max=Math.max(max,ds.size[ds.findPar(i)]);
84        }
85        return max;
86    }
87}