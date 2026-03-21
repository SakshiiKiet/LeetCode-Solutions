1
2class Solution {
3    public int[][] merge(int[][] intervals) {
4
5        List<int[]> res = new ArrayList<>();
6
7        if (intervals == null || intervals.length == 0)
8            return res.toArray(new int[0][]);
9
10        // sort by start
11        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
12
13        int start = intervals[0][0];
14        int end = intervals[0][1];
15
16        for (int[] i : intervals) {
17
18            if (i[0] <= end) {
19                end = Math.max(end, i[1]);
20            } else {
21                res.add(new int[]{start, end});
22                start = i[0];
23                end = i[1];
24            }
25        }
26
27        res.add(new int[]{start, end});
28
29        return res.toArray(new int[res.size()][]);
30    }
31}