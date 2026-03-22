1class Solution {
2    public int candy(int[] ratings) {
3        int n = ratings.length;
4        int sum = 1;     // first child gets 1 candy
5        int i = 1;
6
7        while (i < n) {
8
9            // CASE 1: equal ratings
10            if (ratings[i] == ratings[i - 1]) {
11                sum += 1;
12                i++;
13                continue;
14            }
15
16            // CASE 2: increasing slope
17            int peak = 1;
18            while (i < n && ratings[i] > ratings[i - 1]) {
19                peak++;
20                sum += peak;
21                i++;
22            }
23
24            // CASE 3: decreasing slope
25            int down = 1;
26            while (i < n && ratings[i] < ratings[i - 1]) {
27                sum += down;
28                down++;
29                i++;
30            }
31
32            // peak correction
33            if (down > peak) {
34                sum += (down - peak);
35            }
36        }
37
38        return sum;
39    }
40}