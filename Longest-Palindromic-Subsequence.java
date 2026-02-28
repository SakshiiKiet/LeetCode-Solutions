1class Solution {
2    public int longestPalindromeSubseq(String s) {
3        String rev = new StringBuilder(s).reverse().toString();
4       return longestCommonSubsequence(s,rev);
5    }
6    public int longestCommonSubsequence(String text1, String text2) {
7        int m = text1.length();
8        int n = text2.length();
9        int[] prev=new int[n+1];
10         //Base Case    
11        for(int j=0;j<n;j++){
12            prev[j]=0;
13        }
14
15        for(int i=1;i<=m;i++){
16             int[] curr=new int[n+1];   
17            for(int j=1;j<=n;j++){
18        if(text1.charAt(i-1)==text2.charAt(j-1)){
19             curr[j]= 1+prev[j-1];
20        }else{
21              curr[j]=Math.max(prev[j],curr[j-1]); //dp[i-1][j],    prev[j]
22                                                    //dp[i][j-1],     curr[j-1]
23            }
24        }
25        prev=curr;
26        }
27        return prev[n];
28}
29}