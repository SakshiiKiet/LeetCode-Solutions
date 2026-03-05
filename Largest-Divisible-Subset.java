1class Solution {
2    public List<Integer> largestDivisibleSubset(int[] nums) {
3       int n = nums.length;
4        Arrays.sort(nums);
5        int[] dp = new int[n];
6        int[] hash = new int[n];
7
8        Arrays.fill(dp, 1);
9
10        int max = 1;
11        int lastIndex = 0;
12
13        for(int i = 0; i < n; i++) {
14
15            hash[i] = i;
16
17            for(int prev = 0; prev < i; prev++) {
18
19                if( nums[i]%nums[prev]==0 && 1 + dp[prev] > dp[i]) {
20                    dp[i] = 1 + dp[prev];
21                    hash[i] = prev;
22                }
23            }
24
25            if(dp[i] > max) {
26                max = dp[i];
27                lastIndex = i;
28            }
29        }
30
31        ArrayList<Integer> lis = new ArrayList<>();
32
33        lis.add(nums[lastIndex]);
34
35        while(hash[lastIndex] != lastIndex) {
36            lastIndex = hash[lastIndex];
37            lis.add(nums[lastIndex]);
38        }
39        return lis;
40    }
41}