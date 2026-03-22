1class Solution {
2    public int candy(int[] ratings) {
3        int n=ratings.length;
4        int[] lc=new int[n];
5        Arrays.fill(lc,1);
6        int[] rc=new int[n];
7        Arrays.fill(rc,1);
8        for(int i=1;i<n;i++){
9            if(ratings[i]>ratings[i-1]){
10            lc[i]=lc[i-1]+1;
11        }
12        }
13         for(int i=n-2;i>=0;i--){
14            if(ratings[i]>ratings[i+1]){
15             rc[i]=rc[i+1]+1;
16        }
17        }
18        int sum=0;
19        for(int i=0;i<n;i++){
20            sum+=Math.max(lc[i],rc[i]);
21        }
22        return sum;
23    }
24}