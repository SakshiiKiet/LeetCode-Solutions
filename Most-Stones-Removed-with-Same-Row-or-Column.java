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
36    public int removeStones(int[][] stones) {
37        int n=stones.length;
38        int maxRow=0;
39        int maxCol=0;
40        // to find grid size
41        for(int i=0;i<n;i++){
42            maxRow=Math.max(maxRow,stones[i][0]);
43            maxCol=Math.max(maxCol,stones[i][1]);
44        }
45        DisjointSet ds=new DisjointSet(maxRow+maxCol+2);
46        HashMap<Integer,Integer>map=new HashMap<>();
47        for(int i=0;i<n;i++){
48            int nodeRow=stones[i][0];
49            int nodeCol=stones[i][1]+maxRow+1;
50            ds.unionBySize(nodeRow,nodeCol);
51            map.put(nodeRow,1);
52            map.put(nodeCol,1);
53        }
54        int c=0;
55        for(Map.Entry<Integer,Integer>it:map.entrySet()){
56            if(ds.findPar(it.getKey())==it.getKey()){
57                c++;
58            }
59        }
60        return n-c;
61    }
62}