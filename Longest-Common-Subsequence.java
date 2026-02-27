1class Solution {
2    int[][] dp;
3    public int longestCommonSubsequence(String text1, String text2) {
4        int m = text1.length();
5        int n = text2.length();
6        dp=new int[m][n];
7        for(int[] rows:dp){
8            Arrays.fill(rows,-1);
9        }
10    return longest(m-1,n-1,text1,text2);
11        
12    }
13    int longest(int i,int j,String text1, String text2){
14        if(i<0 || j<0) return 0;
15        if(dp[i][j]!=-1) return dp[i][j];
16        if(text1.charAt(i)==text2.charAt(j)){
17            return dp[i][j]= 1+longest(i-1,j-1,text1,text2);
18        }else{
19             return dp[i][j]=Math.max(longest(i-1,j,text1,text2),longest(i,j-1,text1,text2));
20        }
21    }
22}
23