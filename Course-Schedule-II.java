1class Solution {
2    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
23        int[] topo=new int[V];
24        int i=0;
25        while(!q.isEmpty()){
26            int node=q.peek();
27            q.poll();
28            topo[i]=node;
29            i++;
30            for(int adjNode:adj.get(node)){
31                indegree[adjNode]--;
32                if(indegree[adjNode]==0){
33                    q.offer(adjNode);
34                }
35            }
36        }
37        if(i==V){
38            return topo;
39        }
40        return new int[]{};
41    }
42}