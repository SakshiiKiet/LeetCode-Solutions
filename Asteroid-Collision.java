1import java.util.*;
2
3class Solution {
4    public int[] asteroidCollision(int[] asteroids) {
5        int n = asteroids.length;
6        List<Integer> list = new ArrayList<>();
7
8        for (int i = 0; i < n; i++) {
9            int curr = asteroids[i];
10
11            if (curr > 0) {
12                list.add(curr);
13            } else {
14                //boolean destroyed = false;
15
16                // While last asteroid in list is moving right and smaller
17                while (!list.isEmpty() && list.get(list.size() - 1) > 0 && list.get(list.size() - 1) < Math.abs(curr)) {
18                    list.remove(list.size() - 1);
19                }
20
21                // If equal magnitudes, both destroyed
22                if (!list.isEmpty() && list.get(list.size() - 1) == Math.abs(curr)) {
23                    list.remove(list.size() - 1);
24                    //destroyed = true;
25                } 
26                // If list empty or top moving left, push current
27                else if (list.isEmpty() || list.get(list.size() - 1) < 0) {
28                    list.add(curr);
29                } 
30                // Else, current asteroid destroyed (no action)
31            }
32        }
33
34        // Convert List → int[]
35        int[] ans = new int[list.size()];
36        for (int i = 0; i < list.size(); i++) {
37            ans[i] = list.get(i);
38        }
39
40        return ans;
41    }
42}
43