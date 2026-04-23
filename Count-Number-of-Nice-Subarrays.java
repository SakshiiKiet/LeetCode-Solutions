1class Solution {
2    public int numberOfSubarrays(int[] nums, int k) {
3        return f(nums, k) - f(nums, k - 1);
4    }
5    int f(int[] nums, int goal){
6        if(goal < 0) return 0;
7        int l = 0, r = 0, c = 0, sum = 0;
8
9        while(r < nums.length){
10            sum += nums[r]%2;
11
12            while(sum > goal){
13                sum -= nums[l]%2;
14                l++;
15            }
16
17            c += r - l + 1;
18            r++;
19        }
20        return c;
21    }
22}