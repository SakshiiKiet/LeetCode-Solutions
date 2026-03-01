1class Solution {
2    int[][]dp;
3    public int minDistance(String word1, String word2) {
4        int n=word1.length();
5        int m=word2.length();
6        return n+m-2*longestCommonSubsequence( word1,  word2);
7    }
8   public int longestCommonSubsequence(String text1, String text2) {
9        int m = text1.length();
10        int n = text2.length();
11        dp=new int[m][n];
12        for(int[] rows:dp){
13            Arrays.fill(rows,-1);
14        }
15    return longest(m-1,n-1,text1,text2);
16        
17    }
18    int longest(int i,int j,String text1, String text2){
19        if(i<0 || j<0) return 0;
20        if(dp[i][j]!=-1) return dp[i][j];
21        if(text1.charAt(i)==text2.charAt(j)){
22            return dp[i][j]= 1+longest(i-1,j-1,text1,text2);
23        }else{
24             return dp[i][j]=Math.max(longest(i-1,j,text1,text2),longest(i,j-1,text1,text2));
25        }
26    }
27}