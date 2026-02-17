1class Solution {
2    public int fib(int n) {
3        if(n<=1) return n;
4        int prev1=1,prev2=0;
5        for(int i=2;i<=n;i++){
6            int curr=prev1+prev2;
7            prev2=prev1;
8            prev1=curr;
9        }
10        return prev1;
11    }
12}