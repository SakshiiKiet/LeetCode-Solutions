1class Solution {
2    public int climbStairs(int n) {
3        if (n <= 1) return 1;
4
5        int prev1=1,prev2=1;
6        for(int i=2;i<=n;i++){
7            int curr=prev1+prev2;
8            prev2=prev1;
9            prev1=curr;
10        }
11        return prev1;
12    }
13}
14