1class Solution {
2    public int kthSmallest(int[][] matrix, int k) {
3        int rows = matrix.length;
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
15         PriorityQueue<Integer>p=new PriorityQueue<>();
16         for(int i=0;i<oneD.length;i++){
17             p.add(oneD[i]);
18         }
19         int top=-1;
20         while(k>0){
21             top=p.poll();
22             k--;
23         }
24       return top;
25    }
26}