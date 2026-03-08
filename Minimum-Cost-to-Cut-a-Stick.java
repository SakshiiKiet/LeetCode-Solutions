1class Solution {
2    int[][]dp;
3    public int minCost(int n, int[] cuts) {
4        int c=cuts.length; //length of array
5        dp=new int[c+1][c+1];
6        for (int[] row : dp) {
7            Arrays.fill(row, -1);
8        }
9        List<Integer>cut=new ArrayList<>();
10        for(int x:cuts){
11            cut.add(x);
12        }
13        cut.add(n);
14        cut.add(0,0);
15        Collections.sort(cut);
16        return f(1,c,cut);
17    }
18    int f(int i,int j,List<Integer> cuts){
19         if (i > j) return 0;
20         if(dp[i][j]!=-1) return dp[i][j];
21        int min = Integer.MAX_VALUE;
22
23        for (int ind = i; ind <= j; ind++) {
24
25            int cost = cuts.get(j + 1) - cuts.get(i - 1)
26                    + f(i, ind - 1, cuts)
27                    + f(ind + 1, j, cuts);
28
29            min = Math.min(min, cost);
30        }
31
32        return dp[i][j]=min;
33    }
34}