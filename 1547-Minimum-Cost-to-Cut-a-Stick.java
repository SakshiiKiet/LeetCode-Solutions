class Solution {
    int[][]dp;
    public int minCost(int n, int[] cuts) {
        int c=cuts.length; //length of array
        dp=new int[c+1][c+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        List<Integer>cut=new ArrayList<>();
        for(int x:cuts){
            cut.add(x);
        }
        cut.add(n);
        cut.add(0,0);
        Collections.sort(cut);
        return f(1,c,cut);
    }
    int f(int i,int j,List<Integer> cuts){
         if (i > j) return 0;
         if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;

        for (int ind = i; ind <= j; ind++) {

            int cost = cuts.get(j + 1) - cuts.get(i - 1)
                    + f(i, ind - 1, cuts)
                    + f(ind + 1, j, cuts);

            min = Math.min(min, cost);
        }

        return dp[i][j]=min;
    }
}