1class Solution {
2    public int longestPalindromeSubseq(String s) {
3        String rev = new StringBuilder(s).reverse().toString();
4       return longestCommonSubsequence(s,rev);
5    }
6    public int longestCommonSubsequence(String text1, String text2) {
7        int m = text1.length();
8        int n = text2.length();
9        int[][] dp=new int[m+1][n+1];
10        for(int i=0;i<m;i++){
11            dp[i][0]=0;
12        }                          //Base Case    
13        for(int j=0;j<n;j++){
14            dp[0][j]=0;
15        }
16
17        for(int i=1;i<=m;i++){
18            for(int j=1;j<=n;j++){
19        if(text1.charAt(i-1)==text2.charAt(j-1)){
20             dp[i][j]= 1+dp[i-1][j-1];
21        }else{
22              dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
23            }
24        }
25        
26        }
27        return dp[m][n];
28}
29}