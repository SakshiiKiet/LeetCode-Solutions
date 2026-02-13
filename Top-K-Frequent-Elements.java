1class Solution {
2    public int[] topKFrequent(int[] nums, int k) {
3        HashMap<Integer,Integer>map=new HashMap<>();
4        for(int i=0;i<nums.length;i++){
5            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
6        }
7        //convert map to list
8        List<Map.Entry<Integer,Integer>>list=new ArrayList<>(map.entrySet());
9    
10     // Step 3: Sort by frequency (descending)
11        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
12
13        // Step 4: Pick top k
14        int[] ans = new int[k];
15        for (int i = 0; i < k; i++) {
16            ans[i] = list.get(i).getKey();
17        }
18
19        return ans;
20}
21}