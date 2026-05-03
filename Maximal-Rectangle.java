1class Solution {
2    public int maximalRectangle(char[][] matrix) {
3       int n= matrix.length;
4       int m=matrix[0].length;
5       int maxarea=0;
6       int[][] pSum=new int[n][m];
7       for(int j=0;j<m;j++){
8        int sum=0;
9        for(int i=0;i<n;i++){
10         if(matrix[i][j]=='1') sum+=1;
11         else sum=0;
12         pSum[i][j]=sum;
13        }
14       }
15       for(int i=0;i<n;i++){
16        maxarea=Math.max(maxarea,largestRecArea(pSum[i]));
17       }
18   return maxarea;
19    }
20    public int largestRecArea(int[] heights){
21        int n=heights.length;
22        int maxarea=0;
23        Stack<Integer>s=new Stack<>();
24        for(int i=0;i<n;i++){
25         while(!s.isEmpty() && heights[i]<heights[s.peek()]){
26            int ele=s.pop();
27            int nse=i;
28            int pse=s.isEmpty()?-1:s.peek();
29            maxarea=Math.max(maxarea,heights[ele]*(nse-pse-1));
30         }
31         s.push(i);
32        }
33        while (!s.isEmpty()) {
34            int nse = heights.length;
35            int ele = s.pop();
36            int pse = s.isEmpty() ? -1 : s.peek();
37            maxarea = Math.max(maxarea, heights[ele] * (nse - pse - 1));
38        }
39        return maxarea;
40    }
41}