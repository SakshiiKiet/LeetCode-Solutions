class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0; int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        return isSubsetSum(nums,target);
    }
    static boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
      boolean[] prev=new boolean[sum+1];

        for(int i=0;i<n;i++){
            prev[0]=true;
        }
        if(sum>=arr[0]){
            prev[arr[0]]=true;
        }
        for(int i=1;i<n;i++){
            boolean[] curr=new boolean[sum+1];
            for(int j=0;j<=sum;j++){
                boolean not=prev[j];
                boolean take=false;
               if(j>=arr[i]){
                take=prev[j-arr[i]];
        }
        curr[j]=not|| take;
            }
            prev=curr;
        }
        
        return prev[sum];
    }
}