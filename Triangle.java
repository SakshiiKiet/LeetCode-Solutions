1class Solution {
2    public int minimumTotal(List<List<Integer>> triangle) {
3        int n=triangle.size();
4        int[] prev=new int[n];
5        for(int j=0;j<n;j++){
6            prev[j]=triangle.get(n-1).get(j);
7        }
8        for(int i=n-2;i>=0;i--){
9            int[] curr=new int[n];
10            for(int j=i;j>=0;j--){
11                int d=triangle.get(i).get(j)+prev[j];
12                int dg=triangle.get(i).get(j)+prev[j+1];
13                curr[j]=Math.min(d,dg);
14            }
15            prev=curr;
16        }
17        return prev[0];
18    }
19}