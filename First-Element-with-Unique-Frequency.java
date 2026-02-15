1class Solution {
2    public int firstUniqueFreq(int[] nums) {
3       HashMap<Integer,Integer>map=new HashMap<>();
4        for(int i=0;i<nums.length;i++){
5            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
6        }
7
8         HashMap<Integer,Integer>freq=new HashMap<>();
9        for(int i:map.values()){
10            freq.put(i,freq.getOrDefault(i,0)+1);
11        }
12        for(int num:nums){
13            int count=map.get(num);
14            if(freq.get(count)==1){
15                return num;
16            }
17        }
18        return -1;
19    }
20}