1import java.util.*;
2
3class Pair {
4    int node, wt;
5    Pair(int node, int wt){
6        this.node = node;
7        this.wt = wt;
8    }
9}
10
11class Tuple {
12    int stops, node, cost;
13
14    Tuple(int stops, int node, int cost){
15        this.stops = stops;
16        this.node = node;
17        this.cost = cost;
18    }
19}
20
21class Solution {
22    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
23
24        // 🔹 Step 1: Build graph
25        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
26        for(int i = 0; i < n; i++){
27            adj.add(new ArrayList<>());
28        }
29
30        for(int i = 0; i < flights.length; i++){
31            int u = flights[i][0];
32            int v = flights[i][1];
33            int wt = flights[i][2];
34
35            adj.get(u).add(new Pair(v, wt));
36        }
37
38        // 🔹 Step 2: Queue (BFS style)
39        Queue<Tuple> q = new LinkedList<>();
40        q.add(new Tuple(0, src, 0)); // stops, node, cost
41
42        int[] dist = new int[n];
43        Arrays.fill(dist, (int)1e9);
44        dist[src] = 0;
45
46        // 🔹 Step 3: BFS traversal
47        while(!q.isEmpty()){
48            int stops = q.peek().stops;
49            int node = q.peek().node;
50            int cost = q.peek().cost;
51             q.poll();   
52
53            // ❗ stop limit exceeded
54            if(stops > k) continue;
55
56            for(Pair it : adj.get(node)){
57                int adjNode = it.node;
58                int edW = it.wt;
59
60                if(cost + edW < dist[adjNode] && stops <= k){
61                    dist[adjNode] = cost + edW;
62                    q.add(new Tuple(stops + 1, adjNode, dist[adjNode]));
63                }
64            }
65        }
66
67        return dist[dst] == (int)1e9 ? -1 : dist[dst];
68    }
69}