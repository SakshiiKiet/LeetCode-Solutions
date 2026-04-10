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
18            return parent[node] = findPar(parent[node]); // path compression
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
36
37    public int findCircleNum(int[][] isConnected) {
38        int n=isConnected.length;
39        DisjointSet ds = new DisjointSet(n);
40        for(int i=0;i<n;i++){
41            for(int j=0;j<n;j++){
42                if(isConnected[i][j]==1){
43                    ds.unionBySize(i,j);
44                }
45            }
46        }
47        int c=0;
48        for(int i=0;i<n;i++){
49            if(ds.parent[i]==i){
50                c++;
51            }
52        }
53        return c;
54    }
55} 