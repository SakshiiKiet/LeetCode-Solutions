1class Solution {
2    public int minDistance(String word1, String word2) {
3        int n=word1.length();
4        int m=word2.length();
5        return n+m-2*longestCommonSubsequence( word1,  word2);
6    }
7    public int longestCommonSubsequence(String text1, String text2) {
8        int m = text1.length();
9        int n = text2.length();
10        int[] prev=new int[n+1];
11         //Base Case    
12        for(int j=0;j<n;j++){
13            prev[j]=0;
14        }
15
16        for(int i=1;i<=m;i++){
17             int[] curr=new int[n+1];   
18            for(int j=1;j<=n;j++){
19        if(text1.charAt(i-1)==text2.charAt(j-1)){
20             curr[j]= 1+prev[j-1];
21        }else{
22              curr[j]=Math.max(prev[j],curr[j-1]); //dp[i-1][j],    prev[j]
23                                                    //dp[i][j-1],     curr[j-1]
24            }
25        }
26        prev=curr;
27        }
28        return prev[n];
29    }
30}