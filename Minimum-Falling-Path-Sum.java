1class Solution {
2    public int minFallingPathSum(int[][] matrix) {
3         int n= matrix[0].length;
4        int[] prev=new int[n];
5         for(int j=0;j<n;j++){
6            prev[j]=matrix[0][j];
7         }
8          for(int i=1;i<n;i++){
9            int[] curr=new int[n];
10            for(int j=0;j<n;j++){
11                int s= matrix[i][j]+prev[j];
12                int ld=Integer.MAX_VALUE;
13                int rd=Integer.MAX_VALUE;
14                if(j-1>=0){
15                 ld=matrix[i][j]+prev[j-1];
16                }
17                if(j+1<n){
18                    rd=matrix[i][j]+prev[j+1];
19                }
20                curr[j]=Math.min(s,Math.min(rd,ld));
21            }
22            prev=curr;
23          }
24         int min=prev[0];
25        for(int j=1;j<n;j++){
26           min=Math.min(min,prev[j]);
27        }
28        return min;
29    }
30}