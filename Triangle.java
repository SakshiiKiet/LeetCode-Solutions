1class Solution {
2    int[][] dp;
3    public int minimumTotal(List<List<Integer>> triangle) {
4        int n=triangle.size();
5        dp=new int[n][n];
6        for(int j=0;j<n;j++){
7            dp[n-1][j]=triangle.get(n-1).get(j);
8        }
9        for(int i=n-2;i>=0;i--){
10            for(int j=i;j>=0;j--){
11                int d=triangle.get(i).get(j)+dp[i+1][j];
12                int dg=triangle.get(i).get(j)+dp[i+1][j+1];
13                dp[i][j]=Math.min(d,dg);
14            }
15        }
16        return dp[0][0];
17    }
18}