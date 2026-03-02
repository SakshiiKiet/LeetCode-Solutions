1class Solution {
2    public int minDistance(String word1, String word2) {
3         int n=word1.length();
4         int m=word2.length();
5         int[] prev=new int[m+1];
6         for(int j=0;j<=m;j++){
7            prev[j]=j;
8         }
9        
10        for(int i=1;i<=n;i++){
11            int[] curr=new int[m+1];
12            curr[0]=i;
13            for(int j=1;j<=m;j++){
14               if(word1.charAt(i-1)==word2.charAt(j-1)){
15                 curr[j]=0 + prev[j-1];
16               } 
17               else{
18                 curr[j]=1+Math.min(curr[j-1],Math.min(prev[j],prev[j-1]));
19               }  
20            }
21            prev=curr;
22        }
23       return prev[m];
24    }
25}