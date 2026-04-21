1class Solution {
2    public int minEatingSpeed(int[] piles, int h) {
3        int l=1;
4        int hi=findMax(piles);
5        while(l<=hi){
6            int m=l+(hi-l)/2;
7            int reqtime=calculate(m,piles);
8            if(reqtime<=h){
9                hi=m-1;
10            }else{
11                l=m+1;
12            }
13        }
14        return l;
15    }
16    int findMax(int[] piles){
17        int max=Integer.MIN_VALUE;
18        for(int i=0;i<piles.length;i++){
19            max=Math.max(max,piles[i]);
20        }
21        return max;
22    }
23    int calculate(int m,int[] piles){
24        int t=0;
25        for(int i=0;i<piles.length;i++){
26            t+=(int)Math.ceil((double)piles[i]/m);
27        }
28         return t;
29    }
30}