1class Solution {
2    public int countSquares(int[][] matrix) {
3        int m=matrix.length; //rows
4        int n=matrix[0].length; //cols
5        int[][] dp=new int[m][n];
6        for(int i=0;i<m;i++) dp[i][0]=matrix[i][0];
7        for(int j=0;j<n;j++) dp[0][j]=matrix[0][j];
8        for(int i=1;i<m;i++){
9           for(int j=1;j<n;j++){
10            if(matrix[i][j]==0){
11               dp[i][j]=0;
12            }else{
13                dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]));
14            }
15
16           }
17        }
18        int sum=0;
19        for(int i=0;i<m;i++){
20            for(int j=0;j<n;j++){
21                sum+=dp[i][j];
22            }
23        }
24        return sum;
25    }
26}