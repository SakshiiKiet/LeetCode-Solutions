class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] prev=new int[n];
        for(int i=0;i<m;i++){
            int[] temp=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    temp[j]=grid[0][0];
                }else{
                    int up=Integer.MAX_VALUE;
                    int l=Integer.MAX_VALUE;
                    if(i>0) up=prev[j]+grid[i][j];
                    if(j>0) l=temp[j-1]+grid[i][j];
                    temp[j]=Math.min(up,l);
                }
            }
            prev=temp;
        }
        return prev[n-1];
    }
}