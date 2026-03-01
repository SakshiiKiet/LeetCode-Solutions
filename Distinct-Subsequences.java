1class Solution {
2    public int numDistinct(String s, String t) {
3        int n=s.length();
4        int m=t.length();
5        int[] prev=new int[m+1];
6        prev[0]=1;
7
8        for(int i=1;i<=n;i++){
9        for(int j=m;j>=1;j--){
10        if(s.charAt(i-1)==t.charAt(j-1)){
11            prev[j]= prev[j-1]+prev[j];
12        }else{
13           prev[j]= prev[j];  
14        }
15         }
16        }
17        return prev[m];
18    }
19    
20}