1class Solution {
2    static class Pair{
3        int freq;
4        int val;
5        Pair(int freq,int val){
6            this.freq=freq;
7            this.val=val;
8        }
9    }
10    public int[] topKFrequent(int[] nums, int k) {
11        HashMap<Integer,Integer>map=new HashMap<>();
12        for(int i=0;i<nums.length;i++){
13            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
14        }
15      
16     // Iterate over map entries
17       PriorityQueue<Pair> p = new PriorityQueue<>((a, b) -> a.freq - b.freq);
18        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
19            p.add(new Pair(e.getValue(), e.getKey()));
20            if (p.size() > k) {
21                p.poll();
22            }
23        }
24
25        int[] ans = new int[k];
26        int i = 0;
27        while (!p.isEmpty()) {
28            ans[i] = p.poll().val;
29            i++;
30        }
31
32        return ans;
33}
34}