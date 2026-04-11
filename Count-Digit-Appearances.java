1class Solution {
2    public int countDigitOccurrences(int[] nums, int digit) {
3        int c=0;
4        for(int i=0;i<nums.length;i++){
5            int n=nums[i];
6            if (n == 0 && digit == 0) {
7                c++;
8                continue;
9            }
10
11            while(n!=0){
12            int dig=n%10;
13            if(dig==digit){
14                c++;
15            }
16            n=n/10;
17            }
18        }
19        return c;
20    }
21}