1class Solution {
2    private int timer=1;
3    void dfs(int node,int parent,int[] vis,ArrayList<ArrayList<Integer>>adj,int[] tin,int[] low,List<List<Integer>>bridges){
4        vis[node]=1;
5        tin[node]=low[node]=timer;
6        timer++;
7        for(Integer it:adj.get(node)){
8            if(it==parent) continue;
9            if(vis[it]==0){
10                dfs(it,node,vis,adj,tin,low,bridges);
11                low[node]=Math.min(low[node],low[it]);
12                //check for bridge- node->it
13                if(low[it]>tin[node]){
14                    bridges.add(Arrays.asList(it,node));
15                }
16            }
17            else{
18                low[node]=Math.min(low[node],low[it]);
19            }
20        }
21    }
22    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
23        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
24        for(int i=0;i<n;i++){
25            adj.add(new ArrayList<>());
26        }
27        for(int i=0;i<connections.size();i++){
28            int u=connections.get(i).get(0);
29            int v=connections.get(i).get(1);
30            adj.get(u).add(v);
31            adj.get(v).add(u);
32        }
33        int[] vis=new int[n];
34        int[] tin=new int[n];
35        int[] low=new int[n];
36        List<List<Integer>>bridges=new ArrayList<>();
37        dfs(0,-1,vis,adj,tin,low,bridges);
38        return bridges;
39    }
40}