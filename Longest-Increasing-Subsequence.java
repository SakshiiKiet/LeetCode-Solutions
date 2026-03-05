1class Solution {
2    public int lengthOfLIS(int[] nums) {
3        int n=nums.length;
4        ArrayList<Integer>temp=new ArrayList<>();
5        temp.add(nums[0]);
6        int len=1;
7        for(int i=1;i<n;i++){
8            if(nums[i]>temp.get(temp.size()-1)){
9                temp.add(nums[i]);
10                len++;
11            }else{
12               int ind = Collections.binarySearch(temp, nums[i]);
13
14                if(ind < 0)
15                    ind = -(ind + 1);   // insertion point
16
17                temp.set(ind, nums[i]);
18            }
19        }
20        return len;
21    }
22}