1class Solution {
2    static class DisjointSet {
3        int[] parent, size;
4
5        DisjointSet(int n) {
6            parent = new int[n];
7            size = new int[n];
8
9            for (int i = 0; i < n; i++) {
10                parent[i] = i;
11                size[i] = 1;
12            }
13        }
14
15        int findPar(int node) {
16            if (node == parent[node])
17                return node;
18            return parent[node] = findPar(parent[node]);
19        }
20
21        void unionBySize(int u, int v) {
22            int pu = findPar(u);
23            int pv = findPar(v);
24
25            if (pu == pv) return;
26
27            if (size[pu] < size[pv]) {
28                parent[pu] = pv;
29                size[pv] += size[pu];
30            } else {
31                parent[pv] = pu;
32                size[pu] += size[pv];
33            }
34        }
35    }
36    public List<List<String>> accountsMerge(List<List<String>> accounts) {
37        int n=accounts.size();
38        DisjointSet ds = new DisjointSet(n);
39        HashMap<String,Integer>map=new HashMap<>();
40      for(int i=0;i<n;i++){
41        for(int j=1;j<accounts.get(i).size();j++){
42            String mail=accounts.get(i).get(j);
43            if(map.containsKey(mail)==false){
44                map.put(mail,i);
45            }else{
46                ds.unionBySize(i,map.get(mail));
47            }
48        }
49      }
50      ArrayList<String>[] mergedMail = new ArrayList[n];
51
52      for (int i = 0; i < n; i++) {
53        mergedMail[i] = new ArrayList<String>();
54       }
55
56      for (Map.Entry<String, Integer> it : map.entrySet()) {
57      String mail = it.getKey();
58      int node = ds.findPar(it.getValue());
59      mergedMail[node].add(mail);
60      }
61
62      List<List<String>> ans = new ArrayList<>();
63
64      for (int i = 0; i < n; i++) {
65      if (mergedMail[i].size() == 0) continue;
66
67      Collections.sort(mergedMail[i]);
68
69      List<String> temp = new ArrayList<>();
70      temp.add(accounts.get(i).get(0));
71
72      for (String it : mergedMail[i]) {
73        temp.add(it);
74      }
75
76      ans.add(temp);
77      }
78     return ans;
79    }
80}