1class Solution {
2    public int findCircleNum(int[][] isConnected) {
3        int V=isConnected.length;
4        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
5        for(int i=0;i<V;i++){
6            adj.add(new ArrayList<>());
7        }
8
9        //To change matrix to adj list
10        for(int i=0;i<V;i++){
11            for(int j=0;j<V;j++){
12                if(isConnected[i][j]==1 && i!=j){
13                    adj.get(i).add(j);
14                }
15            }
16        }
17        int[] vis=new int[V];
18        int c=0;
19        for(int i=0;i<V;i++){
20            if(vis[i]==0){
21                c++;
22                dfs(i,adj,vis);
23            }
24        }
25        return c;
26    }
27    void dfs(int node,ArrayList<ArrayList<Integer>>adj,int[] vis){
28        vis[node]=1;
29        for(int i=0;i<adj.get(node).size();i++){
30            int neighbour=adj.get(node).get(i);
31            if(vis[neighbour]==0){
32                dfs(neighbour,adj,vis);
33            }
34        }
35    }
36}