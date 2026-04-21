1class Solution {
2    public int findKthPositive(int[] arr, int k) {
3      int l=0;
4      int h=arr.length-1;
5      while(l<=h){
6        int mid=l+(h-l)/2;
7        int miss=arr[mid]-(mid+1);
8        if(miss<k){
9            l=mid+1;
10        }else{
11            h=mid-1;
12        }
13      }
14      return l+k;
15    }
16}