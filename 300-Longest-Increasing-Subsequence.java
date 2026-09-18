class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[]ahead=new int[n+1];
       for(int prev=0;prev<=n;prev++){
        ahead[prev]=0;
       }
       for(int i=n-1;i>=0;i--){
        int[]curr=new int[n+1];
        for(int prev=i-1;prev>=-1;prev--){
           int not=ahead[prev+1];
        int take=0;
        if(prev==-1 || nums[i]>nums[prev]){
            take=1+ahead[i+1];
        }
        curr[prev+1]=Math.max(take,not);
        }
        ahead=curr;
       }
        return ahead[0];
    }
}