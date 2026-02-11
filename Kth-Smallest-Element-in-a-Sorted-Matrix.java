1class Solution {
2    public int kthSmallest(int[][] matrix, int k) {
3         int rows = matrix.length;
4         int cols = matrix[0].length;
5
6          int[] oneD = new int[rows * cols];
7
8          int index = 0;
9
10          for (int i = 0; i < rows; i++) {
11            for (int j = 0; j < cols; j++) {
12                    oneD[index++] = matrix[i][j];
13              }
14          }
15          Arrays.sort(oneD);
16          return oneD[k-1];
17    }
18}