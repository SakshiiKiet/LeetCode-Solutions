class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
         int n=word1.length();
         int m=word2.length();
         dp=new int[n][m];
         for(int[] rows:dp){
            Arrays.fill(rows,-1);
         }
        return operations(n-1,m-1,word1,word2);
    }
    int operations(int i,int j,String s1, String s2){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
          return dp[i][j]=0 + operations(i-1,j-1,s1,s2);
        } 
        return dp[i][j]=1+Math.min(operations(i,j-1,s1,s2),Math.min(operations(i-1,j,s1,s2),operations(i-1,j-1,s1,s2)));
    }
}