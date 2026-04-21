1class Solution {
2    public int mySqrt(int x) {
3       int l=1;
4       int h=x;
5       if(x==0 || x==1){
6        return x;
7       }
8       while(l<=h){
9        int mid=l+(h-l)/2;
10        if((long)mid*mid<=x){
11            l=mid+1;
12        }else{
13            h=mid-1;
14        }
15       }
16       return h;
17    }
18}