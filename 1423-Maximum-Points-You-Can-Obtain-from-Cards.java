class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ls=0,rs=0,maxsum=0;
        for(int i=0;i<k;i++){
            ls+=cardPoints[i];
            maxsum=ls;
        }
        int rind=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            ls-=cardPoints[i];
            rs+=cardPoints[rind];
            rind-=1;
            maxsum=Math.max(maxsum,ls+rs);
        }
        return maxsum;
    }
}