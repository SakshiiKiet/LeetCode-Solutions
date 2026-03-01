1class Solution {
2    public int numDistinct(String s, String t) {
3        int n=s.length();
4        int m=t.length();
5        int[][] dp=new int[n+1][m+1];
6        for(int i=0;i<=n;i++){
7            dp[i][0]=1;
8        }                          //Base Case    
9        for(int j=1;j<=m;j++){ //j starts from 1 becoz in previous loop u already put at j=0==1
10            dp[0][j]=0;
11        }
12
13        for(int i=1;i<=n;i++){
14            for(int j=1;j<=m;j++){
15        if(s.charAt(i-1)==t.charAt(j-1)){
16            dp[i][j]= dp[i-1][j-1]+dp[i-1][j];
17        }else{
18           dp[i][j]= dp[i-1][j];  
19        }
20         }
21        }
22        return dp[n][m];
23    }
24    
25}