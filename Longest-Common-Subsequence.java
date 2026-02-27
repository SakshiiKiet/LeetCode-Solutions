1class Solution {
2    public int longestCommonSubsequence(String text1, String text2) {
3        int m = text1.length();
4        int n = text2.length();
5        int[] prev=new int[n+1];
6         //Base Case    
7        for(int j=0;j<n;j++){
8            prev[j]=0;
9        }
10
11        for(int i=1;i<=m;i++){
12             int[] curr=new int[n+1];   
13            for(int j=1;j<=n;j++){
14        if(text1.charAt(i-1)==text2.charAt(j-1)){
15             curr[j]= 1+prev[j-1];
16        }else{
17              curr[j]=Math.max(prev[j],curr[j-1]); //dp[i-1][j],    prev[j]
18                                                    //dp[i][j-1],     curr[j-1]
19            }
20        }
21        prev=curr;
22        }
23        return prev[n];
24    }
25}
26