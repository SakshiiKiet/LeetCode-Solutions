1class Solution {
2    public int candy(int[] ratings) {
3        int n=ratings.length;
4        int[] lc=new int[n];
5        Arrays.fill(lc,1);
6        for(int i=1;i<n;i++){
7            if(ratings[i]>ratings[i-1]){
8            lc[i]=lc[i-1]+1;
9        }
10        }
11          int sum = Math.max(lc[n - 1], 1);
12        int right = 1;
13
14        for (int i = n - 2; i >= 0; i--) {
15            if (ratings[i] > ratings[i + 1]) {
16                right++;
17            } else {
18                right = 1;
19            }
20
21            sum += Math.max(lc[i], right);
22        }
23
24        return sum;
25    }
26}