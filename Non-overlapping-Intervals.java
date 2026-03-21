1class Solution {
2    public int eraseOverlapIntervals(int[][] intervals) {
3       if(intervals.length==0){
4        return 0;
5       }
6       Arrays.sort(intervals,(a,b)->a[1]-b[1]);
7       int c=1;
8       int end=intervals[0][1];
9       for(int i=1;i<intervals.length;i++){
10          if(intervals[i][0]>=end){
11            c+=1;
12            end=intervals[i][1];
13          }
14       }
15       return intervals.length-c;
16    }
17}