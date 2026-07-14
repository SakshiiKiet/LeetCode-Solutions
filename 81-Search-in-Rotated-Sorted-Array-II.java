class Solution {
    public boolean search(int[] nums, int target) {
        return search1( nums, 0, nums.length-1, target);
    }
    static boolean search1(int[] nums,int s,int e,int target){
       while(s<=e){
        int mid=s+(e-s)/2;
        if(nums[mid]==target){
            return true;
        }
        if(nums[s]==nums[mid] && nums[mid]==nums[e]){
            s++;
            e--;
            continue;
        }
         if(nums[s]<=nums[mid]){
         if(target>=nums[s] && target<=nums[mid]){
            return search1( nums, s, mid-1, target);
         }else{
           return search1( nums, mid+1, e, target);
         }
        } else{
            if(target>=nums[mid] && target<=nums[e]){
           return search1( nums, mid+1, e, target);
         }else{
           return search1( nums, s, mid-1, target);
         }
        }
     
    }
    return false;
}
}