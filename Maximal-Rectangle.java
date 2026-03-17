1import java.util.*;
2
3class Solution {
4    public int maximalRectangle(char[][] matrix) {
5        int n = matrix.length;
6        int m = matrix[0].length;
7        int maxArea = 0;
8
9        int[] height = new int[m];  
10
11        for (int i = 0; i < n; i++) {
12
13            for (int j = 0; j < m; j++) {
14                if (matrix[i][j] == '1') 
15                    height[j] += 1;
16                else 
17                    height[j] = 0;
18            }
19
20            int area = largestRectangleArea(height);
21            maxArea = Math.max(maxArea, area);
22        }
23        return maxArea;
24    }
25
26    public int largestRectangleArea(int[] heights) {
27        Stack<Integer> st = new Stack<>();
28        int maxarea = 0;
29
30        for (int i = 0; i < heights.length; i++) {
31            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
32                int element = st.pop();
33                int nse = i;
34                int pse = st.isEmpty() ? -1 : st.peek();
35                maxarea = Math.max(maxarea, heights[element] * (nse - pse - 1));
36            }
37            st.push(i);
38        }
39
40        while (!st.isEmpty()) {
41            int nse = heights.length;
42            int element = st.pop();
43            int pse = st.isEmpty() ? -1 : st.peek();
44            maxarea = Math.max(maxarea, heights[element] * (nse - pse - 1));
45        }
46
47        return maxarea;
48    }
49}