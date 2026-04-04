1class Pair {
2    int node;
3    long dis;  //time=dis
4    Pair(int node, long dis){
5        this.node = node;
6        this.dis = dis;
7    }
8}
9
10class Solution {
11    public int countPaths(int n, int[][] roads) {
12        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
13        for(int i=0;i<n;i++){
14            adj.add(new ArrayList<>());
15        }
16        for(int i=0;i<roads.length;i++){
17            int u=roads[i][0];
18            int v=roads[i][1];
19            int t=roads[i][2];
20            adj.get(u).add(new Pair(v,t));
21            adj.get(v).add(new Pair(u,t));
22        }
23       PriorityQueue<Pair> p = new PriorityQueue<>((x, y) -> Long.compare(x.dis, y.dis));
24        long[] dist=new long[n];
25        int[] ways=new int[n];
26         Arrays.fill(dist, Long.MAX_VALUE);
27        dist[0]=0;
28        ways[0]=1;
29        p.add(new Pair(0,0));
30        int mod=(int)(1e9+7);
31        while(!p.isEmpty()){
32           long dis=p.peek().dis;
33            int node=p.peek().node;
34            p.poll();
35            if(dis > dist[node]) continue;
36            for(Pair it:adj.get(node)){
37               int adjNode=it.node;
38              long edW=it.dis;
39               // this is the first time i am coming
40               //with this short distance
41               if(dis+edW<dist[adjNode]){
42                dist[adjNode]=dis+edW;
43                p.add(new Pair(adjNode, dist[adjNode]));
44                ways[adjNode]=ways[node];
45               }else if(dis+edW==dist[adjNode]){
46                ways[adjNode]=(ways[adjNode]+ways[node])%mod;
47               }
48            }
49        } 
50        return ways[n-1]%mod;  
51    }
52}