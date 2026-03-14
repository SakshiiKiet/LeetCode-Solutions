1class Solution {
2    public int minimumIndex(int[] capacity, int itemSize) {
3        int n=capacity.length;
4        int min=Integer.MAX_VALUE;
5        int ind=-1;
6        for(int i=0;i<n;i++){
7            if(capacity[i]>=itemSize && min>capacity[i]){
8                min=capacity[i];
9                ind=i;
10            }
11        }
12        return ind;
13    }
14}