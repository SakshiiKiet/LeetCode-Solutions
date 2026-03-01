1class Solution {
2    public int minInsertions(String s) {
3        return s.length()-longestPalindromeSubseq( s);
4    }
5    public int longestPalindromeSubseq(String s) {
6        String rev = new StringBuilder(s).reverse().toString();
7        return longestCommonSubsequence(s,rev);
8    }
9    public int longestCommonSubsequence(String text1, String text2) {
10        int m = text1.length();
11        int n = text2.length();
12        int[][] dp=new int[m+1][n+1];
13        for(int i=0;i<m;i++){
14            dp[i][0]=0;
15        }                          //Base Case    
16        for(int j=0;j<n;j++){
17            dp[0][j]=0;
18        }
19
20        for(int i=1;i<=m;i++){
21            for(int j=1;j<=n;j++){
22        if(text1.charAt(i-1)==text2.charAt(j-1)){
23             dp[i][j]= 1+dp[i-1][j-1];
24        }else{
25              dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
26            }
27        }
28        
29        }
30        return dp[m][n];
31}
32}