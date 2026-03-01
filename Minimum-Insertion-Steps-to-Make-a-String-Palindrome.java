1class Solution {
2    public int minInsertions(String s) {
3        return s.length()-longestPalindromeSubseq( s);
4    }
5    public int longestPalindromeSubseq(String s) {
6        String rev = new StringBuilder(s).reverse().toString();
7        return longestCommonSubsequence(s,rev);
8    }
9     public int longestCommonSubsequence(String text1, String text2) {
10        int m = text1.length();
11        int n = text2.length();
12        int[] prev=new int[n+1];
13         //Base Case    
14        for(int j=0;j<n;j++){
15            prev[j]=0;
16        }
17
18        for(int i=1;i<=m;i++){
19             int[] curr=new int[n+1];   
20            for(int j=1;j<=n;j++){
21        if(text1.charAt(i-1)==text2.charAt(j-1)){
22             curr[j]= 1+prev[j-1];
23        }else{
24              curr[j]=Math.max(prev[j],curr[j-1]); //dp[i-1][j],    prev[j]
25                                                    //dp[i][j-1],     curr[j-1]
26            }
27        }
28        prev=curr;
29        }
30        return prev[n];
31}
32}