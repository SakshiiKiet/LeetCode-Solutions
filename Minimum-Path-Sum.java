1class Solution {
2    public int minPathSum(int[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        int[] prev = new int[n];
6       for(int i=0;i<m;i++){
7          int[] temp=new int[n];
8        for(int j=0;j<n;j++){
9            if(i==0 && j==0){
10                temp[j]=grid[0][0];
11            }else{
12                 int up = Integer.MAX_VALUE;
13                    int left = Integer.MAX_VALUE;
14
15                if (i > 0) up = grid[i][j] +prev[j];
16                if (j > 0) left = grid[i][j] +temp[j - 1];
17                temp[j]=Math.min(up,left);
18            }
19        }
20        prev=temp;
21       }
22        return prev[n-1];
23    }
24}