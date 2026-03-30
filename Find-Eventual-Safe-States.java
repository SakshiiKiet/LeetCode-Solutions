1class Solution {
2    public List<Integer> eventualSafeNodes(int[][] graph) {
3     int V=graph.length;
4     int[] vis=new int[V];
5     int[] pathvis=new int[V];
6     int[] check=new int[V];
7     List<Integer>safe=new ArrayList<>();
8     for(int i=0;i<V;i++){
9        if(vis[i]==0){
10            dfs(i,vis,pathvis,graph,check);
11        }
12     }   
13    for(int i=0;i<V;i++){
14        if(check[i]==1){
15            safe.add(i);
16        }
17    }
18    return safe;
19    }
20 boolean dfs(int node,int[] vis,int[] pathvis,int[][] graph,int[] check){
21    vis[node]=1;
22    pathvis[node]=1;
23    check[node]=0;
24    //traverse for adjacent nodes
25    for(int adjNode:graph[node]){
26        // if not visited
27        if(vis[adjNode]==0){
28            if(dfs(adjNode,vis,pathvis,graph,check)==true){
29                check[adjNode]=0;                                  //cycle
30                return true;
31            }
32        }else if(pathvis[adjNode]==1){
33            return true;
34        }  
35    }
36    check[node]=1;
37    pathvis[node]=0;
38    return false;
39 }
40}