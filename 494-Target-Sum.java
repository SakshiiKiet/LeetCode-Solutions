
class Solution {
    int[][]dp;
    public int findTargetSumWays(int[] nums, int target) {
       return countPartitions(nums,target);
    }
       public int countPartitions(int[] arr, int diff) {
       int n=arr.length;
       int totsum=0;
       for(int i=0;i<n;i++){
           totsum+=arr[i];
       }
       if(totsum-diff<0 || ((totsum-diff)%2)!=0) return 0;
       int target=(totsum-diff)/2;
       dp=new int[n][target+1];
       for(int[] rows:dp){
           Arrays.fill(rows,-1);
       }
       return count(n-1,target,arr);
    }
    int count(int i,int target,int[] arr){
       if (i == 0) {
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }

        if(dp[i][target]!=-1) return dp[i][target];
        int notTake=count(i-1,target, arr);
        int Take=0;
        if(target>=arr[i]){
            Take=count(i-1,target-arr[i],arr);
        }
        return dp[i][target]=notTake+Take;
    }
}