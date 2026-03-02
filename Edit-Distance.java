1class Solution {
2    int[][] dp;
3    public int minDistance(String word1, String word2) {
4         int n=word1.length();
5         int m=word2.length();
6         dp=new int[n][m];
7         for(int[] rows:dp){
8            Arrays.fill(rows,-1);
9         }
10        return operations(n-1,m-1,word1,word2);
11    }
12    int operations(int i,int j,String s1, String s2){
13        if(i<0) return j+1;
14        if(j<0) return i+1;
15        if(dp[i][j]!=-1) return dp[i][j];
16        if(s1.charAt(i)==s2.charAt(j)){
17          return dp[i][j]=0 + operations(i-1,j-1,s1,s2);
18        } 
19        return dp[i][j]=1+Math.min(operations(i,j-1,s1,s2),Math.min(operations(i-1,j,s1,s2),operations(i-1,j-1,s1,s2)));
20    }
21}