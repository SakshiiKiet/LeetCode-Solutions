1class Solution {
2    public boolean isMatch(String s, String p) {
3        int n = s.length();
4        int m = p.length();
5        boolean[] prev = new boolean[n+1];   // dp[i][j] → pattern i, string j
6        
7        // Base cases
8       prev[0]=true;
9       for(int j=1;j<=n;j++){
10        prev[j]=false;
11       }
12       for(int i=1;i<=m;i++){
13        boolean[] curr = new boolean[n + 1];
14        
15        boolean flag=true;
16        for(int ii=1;ii<=i;ii++){
17            if (p.charAt(ii-1) != '*'){
18                 flag=false;
19                 break;
20            } 
21            }
22            // for every row
23            // u are assigning oth col's value
24            curr[0]=flag;
25        for(int j=1;j<=n;j++){
26          // Match or '?'
27        if ( p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?') {
28            curr[j] = prev[ j - 1] ;
29        }
30        // '*'
31         else if(p.charAt(i-1) == '*') {
32            curr[j] = prev[j]  // '*' matches empty
33               || curr[j - 1];  // '*' matches one or more chars
34        }else{
35          // No match
36         curr[j] = false;
37        }
38        }
39        prev=curr;
40       }
41        return prev[n];
42    }
43}