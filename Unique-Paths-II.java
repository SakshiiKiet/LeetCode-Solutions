1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3        int m=obstacleGrid.length;
4        int n=obstacleGrid[0].length;
5       int[] prev=new int[n];
6           for(int i=0;i<m;i++){
7            int[] temp = new int[n];
8            for(int j=0;j<n;j++){
9                if(obstacleGrid[i][j]==1){
10                  temp[j]=0;
11               }else if(i==0 && j==0){
12                temp[j]=1;
13                }else{
14                 int up = (i > 0) ? prev[j] : 0;
15                    int left = (j > 0) ? temp[j - 1] : 0;
16                    temp[j] = up + left;
17               }
18          }
19        prev=temp;
20        }
21        return prev[n-1];     
22  }
23}