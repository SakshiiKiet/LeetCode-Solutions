1class Solution {
2    public int numDistinct(String s, String t) {
3        int n=s.length();
4        int m=t.length();
5        int[] prev=new int[m+1];
6        prev[0]=1;
7
8        for(int i=1;i<=n;i++){
9            int[] curr=new int[m+1];
10             curr[0]=1;
11        for(int j=1;j<=m;j++){
12        if(s.charAt(i-1)==t.charAt(j-1)){
13            curr[j]= prev[j-1]+prev[j];
14        }else{
15           curr[j]= prev[j];  
16        }
17         }
18         prev=curr;
19        }
20        return prev[m];
21    }
22    
23}