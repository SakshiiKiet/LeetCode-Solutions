1class Solution {
2
3    static class DisjointSet {
4        int[] parent, size;
5
6        DisjointSet(int n) {
7            parent = new int[n];
8            size = new int[n];
9
10            for (int i = 0; i < n; i++) {
11                parent[i] = i;
12                size[i] = 1;
13            }
14        }
15
16        int findPar(int node) {
17            if (node == parent[node])
18                return node;
19            return parent[node] = findPar(parent[node]);
20        }
21
22        void unionBySize(int u, int v) {
23            int pu = findPar(u);
24            int pv = findPar(v);
25
26            if (pu == pv) return;
27
28            if (size[pu] < size[pv]) {
29                parent[pu] = pv;
30                size[pv] += size[pu];
31            } else {
32                parent[pv] = pu;
33                size[pu] += size[pv];
34            }
35        }
36    }
37
38    public int makeConnected(int n, int[][] connections) {
39
40        // Step 1: Check if enough edges exist
41        if (connections.length < n - 1) return -1;
42
43        DisjointSet ds = new DisjointSet(n);
44
45        // Step 2: Connect components
46        for (int[] edge : connections) {
47            int u = edge[0];
48            int v = edge[1];
49            ds.unionBySize(u, v);
50        }
51
52        // Step 3: Count components
53        int components = 0;
54        for (int i = 0; i < n; i++) {
55            if (ds.findPar(i) == i) {
56                components++;
57            }
58        }
59
60        // Step 4: Need (components - 1) operations
61        return components - 1;
62    }
63}