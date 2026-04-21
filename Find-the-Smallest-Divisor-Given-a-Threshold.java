1class Solution {
2    public int smallestDivisor(int[] nums, int threshold) {
3        int l=1;
4        int h=findMax(nums);
5        while(l<=h){
6            int m=l+(h-l)/2;
7            int val=calculate(nums,m);
8            if(val<=threshold){
9                h=m-1;
10            }else{
11                l=m+1;
12            }
13        }
14        return l;
15    }
16    int findMax(int[] nums){
17        int max=Integer.MIN_VALUE;
18        for(int i=0;i<nums.length;i++){
19            max=Math.max(max,nums[i]);
20        }
21        return max;
22    }
23    int calculate(int[] nums,int m){
24        int s=0;
25        for(int i=0;i<nums.length;i++){
26            s+=(int)Math.ceil((double)nums[i]/m);
27        }
28        return s;
29    }
30}