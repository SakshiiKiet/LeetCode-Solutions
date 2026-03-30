1class Solution {
2    public boolean canFinish(int numCourses, int[][] prerequisites) {
3        int V= numCourses;
4        List<List<Integer>>adj=new ArrayList<>();
5        for(int i=0;i<V;i++){
6            adj.add(new ArrayList<>());
7        }
8        for(int i=0;i<prerequisites.length;i++){
9            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
10        }
11        int[] indegree=new int[V];
12        for(int i=0;i<V;i++){
13            for(int adjNode:adj.get(i)){
14                indegree[adjNode]++;
15            }
16        }
17        Queue<Integer>q=new LinkedList<>();
18        for(int i=0;i<V;i++){
19            if(indegree[i]==0){
20                q.offer(i);
21            }
22        }
23        ArrayList<Integer>topo=new ArrayList<>();
24        while(!q.isEmpty()){
25            int node=q.peek();
26            q.poll();
27            topo.add(node);
28            for(int adjNode:adj.get(node)){
29                indegree[adjNode]--;
30                if(indegree[adjNode]==0){
31                    q.offer(adjNode);
32                }
33            }
34        }
35        if(topo.size()==V){
36            return true;
37        }
38        return false;
39    }
40}