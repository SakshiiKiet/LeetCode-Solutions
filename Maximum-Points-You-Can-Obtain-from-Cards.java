1class Solution {
2    public int maxScore(int[] cardPoints, int k) {
3        int ls=0,rs=0,maxsum=0;
4        for(int i=0;i<k;i++){
5            ls+=cardPoints[i];
6            maxsum=ls;
7        }
8        int rind=cardPoints.length-1;
9        for(int i=k-1;i>=0;i--){
10            ls-=cardPoints[i];
11            rs+=cardPoints[rind];
12            rind-=1;
13            maxsum=Math.max(maxsum,ls+rs);
14        }
15        return maxsum;
16    }
17}