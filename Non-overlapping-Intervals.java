1class Solution {
2    public int eraseOverlapIntervals(int[][] intervals) {
3
4        if (intervals.length == 0) return 0;
5
6        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
7
8        int count = 0;
9        int end = intervals[0][1];
10
11        for (int i = 1; i < intervals.length; i++) {
12
13            if (intervals[i][0] < end) {
14                count++; // remove this interval
15            } else {
16                end = intervals[i][1];
17            }
18        }
19
20        return count;
21    }
22}