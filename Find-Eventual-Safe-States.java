1class Solution {
2    public List<Integer> eventualSafeNodes(int[][] graph) {
3         int V=graph.length;
4        
5        List<List<Integer>>adjrev=new ArrayList<>();
6        for(int i=0;i<V;i++){
7            adjrev.add(new ArrayList<>());
8        }
9        int[] indegree=new int[V];
10        for(int i=0;i<V;i++){
11            for(int adjNode:graph[i]){
12                adjrev.get(adjNode).add(i);
13                indegree[i]++;
14            }
15        }
16        List<Integer>safe=new ArrayList<>();
17        Queue<Integer>q=new LinkedList<>();
18        for(int i=0;i<V;i++){
19            if(indegree[i]==0){
20                q.offer(i);
21            }
22        }
23         while(!q.isEmpty()){
24            int node=q.peek();
25            q.poll();
26            safe.add(node);
27            for(int adjNode:adjrev.get(node)){
28                indegree[adjNode]--;
29                if(indegree[adjNode]==0){
30                    q.offer(adjNode);
31                }
32            }
33         }
34         Collections.sort(safe);
35         return safe;
36    }
37}