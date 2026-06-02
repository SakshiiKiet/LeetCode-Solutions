1
2class Solution {
3    int[][]dp;
4    public int findTargetSumWays(int[] nums, int target) {
5       return countPartitions(nums,target);
6    }
7       public int countPartitions(int[] arr, int diff) {
8       int n=arr.length;
9       int totsum=0;
10       for(int i=0;i<n;i++){
11           totsum+=arr[i];
12       }
13       if(totsum-diff<0 || ((totsum-diff)%2)!=0) return 0;
14       int target=(totsum-diff)/2;
15       dp=new int[n][target+1];
16       for(int[] rows:dp){
17           Arrays.fill(rows,-1);
18       }
19       return count(n-1,target,arr);
20    }
21    int count(int i,int target,int[] arr){
22       if (i == 0) {
23            if (target == 0 && arr[0] == 0) return 2;
24            if (target == 0 || target == arr[0]) return 1;
25            return 0;
26        }
27
28        if(dp[i][target]!=-1) return dp[i][target];
29        int notTake=count(i-1,target, arr);
30        int Take=0;
31        if(target>=arr[i]){
32            Take=count(i-1,target-arr[i],arr);
33        }
34        return dp[i][target]=notTake+Take;
35    }
36}