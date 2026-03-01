1class Solution {
2    public int minDistance(String word1, String word2) {
3        int n=word1.length();
4        int m=word2.length();
5        return n+m-2*longestCommonSubsequence( word1,  word2);
6    }
7    public int longestCommonSubsequence(String text1, String text2) {
8        int m = text1.length();
9        int n = text2.length();
10        int[][] dp=new int[m+1][n+1];
11        for(int i=0;i<m;i++){
12            dp[i][0]=0;
13        }                          //Base Case    
14        for(int j=0;j<n;j++){
15            dp[0][j]=0;
16        }
17
18        for(int i=1;i<=m;i++){
19            for(int j=1;j<=n;j++){
20        if(text1.charAt(i-1)==text2.charAt(j-1)){
21             dp[i][j]= 1+dp[i-1][j-1];
22        }else{
23              dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
24            }
25        }
26        
27        }
28        return dp[m][n];
29    }
30}
31