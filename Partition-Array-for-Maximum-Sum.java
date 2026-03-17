1class Solution {
2    public int maxSumAfterPartitioning(int[] arr, int k) {
3        int n=arr.length;
4         int[] dp=new int[n+1];
5         dp[n]=0;
6         for(int index=n-1;index>=0;index--){
7          int maxAns=Integer.MIN_VALUE;
8        int len=0;
9        int max=Integer.MIN_VALUE;
10        for(int i=index;i<Math.min(arr.length,index+k);i++){
11            len++;
12            max=Math.max(max,arr[i]);
13            int sum=(len*max)+dp[i+1];
14            maxAns=Math.max(maxAns,sum);
15        }
16        dp[index]=maxAns;
17         }
18         return dp[0];
19    }
20}