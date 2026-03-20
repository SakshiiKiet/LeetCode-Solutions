1import java.util.*;
2
3class Solution {
4    public int[][] insert(int[][] intervals, int[] newInterval) {
5
6        List<int[]> res = new ArrayList<>();
7        int n = intervals.length;
8        int i = 0;
9
10        // add all left
11        while (i < n && intervals[i][1] < newInterval[0]) {
12            res.add(intervals[i]);
13            i++;
14        }
15
16        // merge overlapping
17        while (i < n && intervals[i][0] <= newInterval[1]) {
18            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
19            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
20            i++;
21        }
22
23        res.add(newInterval);
24
25        // add remaining
26        while (i < n) {
27            res.add(intervals[i]);
28            i++;
29        }
30
31        return res.toArray(new int[res.size()][]);
32    }
33}