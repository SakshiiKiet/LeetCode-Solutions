1class Solution {
2
3    // Count elements <= mid
4    static int countLessEqual(int[][] mat, int n, int mid) {
5
6        int count = 0;
7        int row = n - 1;
8        int col = 0;
9
10        while (row >= 0 && col < n) {
11
12            if (mat[row][col] <= mid) {
13                count += (row + 1);   // All elements above are also <= mid
14                col++;               // Move right
15            } else {
16                row--;               // Move up
17            }
18        }
19
20        return count;
21    }
22
23    public int kthSmallest(int[][] matrix, int k) {
24      int n= matrix.length;
25        int low = matrix[0][0];
26        int high = matrix[n - 1][n - 1];
27
28        while (low <= high) { 
29
30            int mid = low + (high - low) / 2;
31
32            int count = countLessEqual(matrix, n, mid);
33
34            if (count >= k) {
35                high = mid-1;      // Search left half 
36            } else {
37                low = mid + 1;   // Search right half
38            }
39        }
40
41        return low;   // kth smallest element
42    }
43}
44