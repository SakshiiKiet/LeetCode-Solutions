class Solution {
    public int rob(int[] nums) {
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<nums.length;i++){
            int not=0+prev;
            int pick=nums[i]+prev2;
            int curr=Math.max(not,pick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}