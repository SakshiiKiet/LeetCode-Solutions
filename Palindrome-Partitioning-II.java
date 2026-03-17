1class Solution {
2    boolean isPalindrome(String s, int l, int r) {
3        while (l < r) {
4            if (s.charAt(l++) != s.charAt(r--)) return false;
5        }
6        return true;
7    }
8    int minCut(String s) {
9        int n=s.length();
10        int[] dp=new int[n+1];
11        dp[n]=0;
12       for(int index=n-1;index>=0;index--){
13       int min = Integer.MAX_VALUE;
14        for (int i = index; i < s.length(); i++) {
15            if (isPalindrome(s, index, i)) {
16                min = Math.min(min, 1 + dp[i + 1]);
17            }
18        }
19        dp[index]=min;
20       }
21        return dp[0]-1;
22    }
23}
24