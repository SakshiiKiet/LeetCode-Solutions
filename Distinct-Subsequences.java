1class Solution {
2    int[][] dp;
3    public int numDistinct(String s, String t) {
4        int n=s.length();
5        int m=t.length();
6        dp=new int[n+1][m+1];
7        for (int[] rows : dp) {
8            Arrays.fill(rows, -1);
9        }
10        return ways(n,m,s,t);
11    }
12    int ways(int i,int j,String s,String t){
13        if(j==0) return 1;
14        if(i==0) return 0;
15        if(dp[i][j]!=-1) return dp[i][j];
16        if(s.charAt(i-1)==t.charAt(j-1)){
17            dp[i][j]= ways(i-1,j-1,s,t)+ways(i-1,j,s,t);
18        }else{
19           dp[i][j]= ways(i-1,j,s,t);  
20        }
21        return dp[i][j];
22    }
23    
24}