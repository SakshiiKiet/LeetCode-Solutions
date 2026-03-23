1class Solution {
2    public int findCircleNum(int[][] isConnected) {
3        int V = isConnected.length;
4        int[] vis = new int[V];
5        int count = 0;
6
7        for(int i = 0; i < V; i++){
8            if(vis[i] == 0){
9                count++;
10                dfs(i, isConnected, vis);
11            }
12        }
13        return count;
14    }
15
16    void dfs(int node, int[][] mat, int[] vis){
17        vis[node] = 1;
18        for(int j = 0; j < mat.length; j++){
19            if(mat[node][j] == 1 && vis[j] == 0){
20                dfs(j, mat, vis);
21            }
22        }
23    }
24} 