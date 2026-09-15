class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] prev=new int[n];
        for(int j=0;j<n;j++){
            prev[j]=triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            int[] temp=new int[n];
            for(int j=i;j>=0;j--){
              int u=prev[j]+triangle.get(i).get(j);
              int l=prev[j+1]+triangle.get(i).get(j);
              temp[j]=Math.min(u,l);
            }
            prev=temp;
        }
        return prev[0];
    }
}