1class Solution {
2    public int findNumberOfLIS(int[] nums) {
3        int n=nums.length;
4        int[]dp=new int[n];
5        int[]count=new int[n];
6        int max=1;
7        Arrays.fill(dp,1);
8         Arrays.fill(count,1);
9        for(int i=0;i<n;i++){
10            for(int prev=0;prev<i;prev++){
11                if(nums[prev]<nums[i] && 1+dp[prev]>dp[i]){
12                    dp[i]=1+dp[prev];
13                    count[i]=count[prev];
14                }else if(nums[prev]<nums[i] && 1+dp[prev]==dp[i]){
15                     count[i]+=count[prev];
16                }
17            }
18            max=Math.max(max,dp[i]);
19        }
20       int c = 0;
21
22        for(int i=0;i<n;i++){
23            if(dp[i] == max){
24                c += count[i];
25            }
26        }
27
28        return c;
29    }
30}