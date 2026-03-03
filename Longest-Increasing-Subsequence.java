1class Solution {
2    public int lengthOfLIS(int[] nums) {
3        int n=nums.length;
4        int[] ahead=new int[n+1];
5        for(int prev=0;prev<=n;prev++){
6            ahead[prev]=0;
7        }
8        for(int i=n-1;i>=0;i--){
9            int[] curr=new int[n+1];
10            for(int prev=i-1;prev>=-1;prev--){
11              int notTake=0+ahead[prev+1]; 
12        int take=0;
13        if(prev==-1 || nums[i]>nums[prev]){
14             take=1+ahead[i+1]; 
15        }
16         curr[prev+1]=Math.max(take,notTake);
17            }
18            ahead=curr;
19        }
20        return ahead[0];
21    }
22}