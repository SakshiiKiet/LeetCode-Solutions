1class Solution {
2    public boolean canJump(int[] nums) {
3        int max=0;
4        for(int i=0;i<nums.length;i++){
5            if(i>max) return false;
6            max=Math.max(max,i+nums[i]);
7        }
8        return true;
9    }
10}