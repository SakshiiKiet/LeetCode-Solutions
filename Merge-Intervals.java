1class Solution {
2    public int[][] merge(int[][] intervals) {
3
4        int n = intervals.length;
5        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
6
7        boolean[] merged = new boolean[n];
8        List<int[]> res = new ArrayList<>();
9
10        for (int i = 0; i < n; i++) {
11
12            if (merged[i]) continue;
13
14            int start = intervals[i][0];
15            int end = intervals[i][1];
16
17            for (int j = i + 1; j < n; j++) {
18
19                if (!merged[j] && intervals[j][0] <= end) {
20                    end = Math.max(end, intervals[j][1]);
21                    merged[j] = true;
22                }
23            }
24
25            res.add(new int[]{start, end});
26        }
27
28        return res.toArray(new int[res.size()][]);
29    }
30}