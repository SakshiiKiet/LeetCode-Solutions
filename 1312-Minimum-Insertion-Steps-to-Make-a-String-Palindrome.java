class Solution {
    int[][] dp;
    public int minInsertions(String s) {
        int n=s.length();
        return n-longestPalindromeSubseq(s);
    }
    public int longestPalindromeSubseq(String s) {
    int n=s.length();
        dp=new int[n+1][n+1];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
        String rev=new StringBuilder(s).reverse().toString();
        return solve(s.length(),rev.length(),s,rev);
    }
    int solve(int i,int j,String s1,String s2){
        if(i==0 || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1)){
            dp[i][j]= 1+solve(i-1,j-1,s1,s2);
        }else{
            dp[i][j]= Math.max(solve(i-1,j,s1,s2),solve(i,j-1,s1,s2));
        }
       return dp[i][j];
    }
}