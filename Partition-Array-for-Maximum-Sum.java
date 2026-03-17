1class Solution {
2    int[] dp;
3    public int maxSumAfterPartitioning(int[] arr, int k) {
4        int n=arr.length;
5        dp=new int[n];
6        Arrays.fill(dp,-1);
7        return func(0,k,arr);
8    }
9    int func(int index,int k,int arr[]){
10        if(index==arr.length) return 0;
11        if(dp[index]!=-1) return dp[index];
12        int maxAns=Integer.MIN_VALUE;
13        int len=0;
14        int max=Integer.MIN_VALUE;
15        for(int i=index;i<Math.min(arr.length,index+k);i++){
16            len++;
17            max=Math.max(max,arr[i]);
18            int sum=(len*max)+func(i+1,k,arr);
19            maxAns=Math.max(maxAns,sum);
20        }
21        return dp[index]=maxAns;
22    }
23}