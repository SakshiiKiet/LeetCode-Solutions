class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n][m];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
        return solve(n-1,m-1,text1,text2);

    }
    int solve(int i, int j,String text1, String text2 ){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            return dp[i][j]=1+solve(i-1,j-1,text1,text2);
        }else{
            return dp[i][j]=0+Math.max(solve(i-1,j,text1,text2),solve(i,j-1,text1,text2));
        }
    }
}