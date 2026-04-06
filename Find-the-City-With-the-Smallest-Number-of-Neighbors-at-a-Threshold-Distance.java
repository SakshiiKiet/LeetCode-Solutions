1import java.util.*;
2
3class Pair {
4    int node;
5    int dist;
6
7    Pair(int node, int dist){
8        this.node = node;
9        this.dist = dist;
10    }
11}
12
13class Solution {
14    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
15
16        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
17        for(int i = 0; i < n; i++){
18            adj.add(new ArrayList<>());
19        }
20
21        // Build graph
22        for(int i = 0; i < edges.length; i++){
23            int u = edges[i][0];
24            int v = edges[i][1];
25            int wt = edges[i][2];
26
27            adj.get(u).add(new Pair(v, wt));
28            adj.get(v).add(new Pair(u, wt));
29        }
30
31        int cityno = -1;
32        int cmax = n;
33
34        // run Dijkstra from each city
35        for(int src = 0; src < n; src++){
36
37            TreeSet<Pair> set = new TreeSet<>(
38                (a, b) -> {
39                    if(a.dist == b.dist) return a.node - b.node;
40                    return a.dist - b.dist;
41                }
42            );
43
44            int[] dist = new int[n];
45            Arrays.fill(dist, (int)1e9);
46
47            dist[src] = 0;
48            set.add(new Pair(src, 0));
49
50            while(!set.isEmpty()){
51                Pair curr = set.pollFirst();
52                int node = curr.node;
53                int dis = curr.dist;
54
55                for(Pair adjNode : adj.get(node)){
56                    int v = adjNode.node;
57                    int wt = adjNode.dist;
58
59                    if(dis + wt < dist[v]){
60
61                        if(dist[v] != (int)1e9){
62                            set.remove(new Pair(v, dist[v]));
63                        }
64
65                        dist[v] = dis + wt;
66                        set.add(new Pair(v, dist[v]));
67                    }
68                }
69            }
70
71            int c = 0;
72            for(int i = 0; i < n; i++){
73                if(dist[i] <= distanceThreshold){
74                    c++;
75                }
76            }
77
78            if(c <= cmax){
79                cmax = c;
80                cityno = src;
81            }
82        }
83
84        return cityno;
85    }
86}