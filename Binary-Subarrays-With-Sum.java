1class Solution {
2    public int numSubarraysWithSum(int[] nums, int goal) {
3        return f(nums, goal) - f(nums, goal - 1);
4    }
5
6    int f(int[] nums, int goal){
7        if(goal < 0) return 0;
8        int l = 0, r = 0, c = 0, sum = 0;
9
10        while(r < nums.length){
11            sum += nums[r];
12
13            while(sum > goal){
14                sum -= nums[l];
15                l++;
16            }
17
18            c += r - l + 1;
19            r++;
20        }
21        return c;
22    }
23}