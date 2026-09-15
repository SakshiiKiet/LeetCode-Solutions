class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int min=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
             min=Math.min(min,solve(n-1,j,matrix));
        }
        return min;
    }
    int solve(int i,int j,int[][] matrix){
        int n=matrix.length;
        if(j<0 || j>=n) return Integer.MAX_VALUE/2;
        if(i==0) return matrix[0][j];
        int p=solve(i-1,j,matrix)+matrix[i][j];
        int q=solve(i-1,j-1,matrix)+matrix[i][j];
        int r=solve(i-1,j+1,matrix)+matrix[i][j];
        return Math.min(p,Math.min(q,r));

    }
}