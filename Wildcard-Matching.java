1class Solution {
2    public boolean isMatch(String s, String p) {
3        int n = s.length();
4        int m = p.length();
5        boolean[][] dp = new boolean[m+1][n+1];   // dp[i][j] → pattern i, string j
6        
7        // Base cases
8       dp[0][0]=true;
9       for(int j=1;j<=n;j++){
10        dp[0][j]=false;
11       }
12       for(int i=1;i<=m;i++){
13        boolean flag=true;
14        for(int ii=1;ii<=i;ii++){
15            if (p.charAt(ii-1) != '*'){
16                 flag=false;
17                 break;
18            } 
19            }
20            dp[i][0]=flag;
21        }
22       for(int i=1;i<=m;i++){
23        for(int j=1;j<=n;j++){
24          // Match or '?'
25        if ( p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?') {
26            dp[i][j] = dp[i - 1][ j - 1] ;
27        }
28        // '*'
29         else if(p.charAt(i-1) == '*') {
30            dp[i][j] = dp[i - 1][j]  // '*' matches empty
31               || dp[i][j - 1];  // '*' matches one or more chars
32        }else{
33          // No match
34         dp[i][j] = false;
35        }
36        }
37       }
38        return dp[m][n];
39    }
40}