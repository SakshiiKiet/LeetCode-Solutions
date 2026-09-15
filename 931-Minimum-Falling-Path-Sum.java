class Solution {
    public int minFallingPathSum(int[][] matrix) {
         int n= matrix[0].length;
        int[] prev=new int[n];
         for(int j=0;j<n;j++){
            prev[j]=matrix[0][j];
         }
          for(int i=1;i<n;i++){
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                int s= matrix[i][j]+prev[j];
                int ld=Integer.MAX_VALUE;
                int rd=Integer.MAX_VALUE;
                if(j-1>=0){
                 ld=matrix[i][j]+prev[j-1];
                }
                if(j+1<n){
                    rd=matrix[i][j]+prev[j+1];
                }
                curr[j]=Math.min(s,Math.min(rd,ld));
            }
            prev=curr;
          }
         int min=prev[0];
        for(int j=1;j<n;j++){
           min=Math.min(min,prev[j]);
        }
        return min;
    }
}