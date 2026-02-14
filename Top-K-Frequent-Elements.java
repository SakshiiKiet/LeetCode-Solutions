1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        HashMap<Integer,Integer>map=new HashMap<>();
4        for(int i=0;i<nums.length;i++){
5            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
6        }
7      
8     ArrayList<ArrayList<Integer>>bucket=new ArrayList<>();
9     //index=freq
10     //value=elements
11     //bucket[i]=elements  having i frequency
12     // max possible frequency = nums.length , creating empty lists or bucket
13        for (int i = 0; i <= nums.length; i++) {
14            bucket.add(new ArrayList<>());
15        }
16
17        // Step 3: Fill the buckets
18        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
19            int element = it.getKey();
20            int freq = it.getValue();
21            bucket.get(freq).add(element);
22        }
23
24        // Step 4: Collect result from highest frequency to lowest
25        int[] ans = new int[k];
26        int idx = 0;
27
28        for (int i = nums.length; i >= 0 && idx < k; i--) {
29            if (bucket.get(i).size() == 0) continue;
30
31            for (int val : bucket.get(i)) {
32                ans[idx++] = val;
33                if (idx == k) break;
34            }
35        }
36
37        return ans;
38
39}
40}