1class Solution {
2    public int longestCommonSubsequence(String text1, String text2) {
3        int m = text1.length();
4        int n = text2.length();
5        int[][] dp=new int[m+1][n+1];
6        for(int i=0;i<m;i++){
7            dp[i][0]=0;
8        }                          //Base Case    
9        for(int j=0;j<n;j++){
10            dp[0][j]=0;
11        }
12
13        for(int i=1;i<=m;i++){
14            for(int j=1;j<=n;j++){
15        if(text1.charAt(i-1)==text2.charAt(j-1)){
16             dp[i][j]= 1+dp[i-1][j-1];
17        }else{
18              dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
19            }
20        }
21        
22        }
23        return dp[m][n];
24    }
25}
26