1class Solution {
2    public int jump(int[] nums) {
3        int n=nums.length;
4        int jumps=0,l=0,r=0;
5        while(r<n-1){
6            int farthest=0;
7            for(int ind=l;ind<=r;ind++){
8                farthest=Math.max(farthest,ind+nums[ind]);
9            }
10            l=r+1;
11            r=farthest;
12            jumps+=1;
13        }
14        return jumps;
15    }
16}