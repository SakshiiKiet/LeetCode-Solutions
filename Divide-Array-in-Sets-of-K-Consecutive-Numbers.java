1class Solution {
2    public boolean isPossibleDivide(int[] nums, int k) {
3         if(nums.length%k!=0) return false;
4
5        // Store the frequency of each card
6        TreeMap<Integer,Integer>freq=new TreeMap<>();
7       for(int i=0;i<nums.length;i++){
8        freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
9       }
10       while(!freq.isEmpty()){
11        int curr=freq.firstKey();
12        for(int i=0;i<k;i++){
13            //curr+i=curr,curr+1,curr+2;
14             if (!freq.containsKey(curr+i)) {
15                    return false;
16                }
17
18                freq.put((curr+i), freq.get(curr+i) - 1);
19
20                if (freq.get(curr+i) == 0) {
21                    freq.remove(curr+i);
22                }
23        }
24       }
25      return true;
26    }
27}