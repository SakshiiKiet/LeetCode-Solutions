1class Solution {
2    int[][]dp;
3    public int maxCoins(int[] nums) {
4        int n=nums.length;
5        dp=new int[n+1][n+1];
6        for (int[] row : dp) {
7            Arrays.fill(row, -1);
8        }
9        List<Integer>num=new ArrayList<>();
10        for (int x : nums) {
11            num.add(x);
12        }
13
14        num.add(1);
15        num.add(0, 1);
16        return maxC(1,nums.length,num);
17    }
18    int maxC(int i,int j,List<Integer> num){
19        if(i>j) return 0;
20        if(dp[i][j]!=-1) return dp[i][j];
21        int max=Integer.MIN_VALUE;
22        for(int ind=i;ind<=j;ind++){
23            int cost= num.get(i - 1) * num.get(ind) * num.get(j + 1)
24                    + maxC(i, ind - 1, num)
25                    + maxC(ind + 1, j, num);
26            max=Math.max(max,cost);
27        }
28        return dp[i][j]=max;
29    }
30}