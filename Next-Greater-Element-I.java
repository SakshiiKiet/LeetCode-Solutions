1class Solution {
2    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
3        int n = nums2.length;
4        Stack<Integer> st = new Stack<>();
5        HashMap<Integer, Integer> map = new HashMap<>();
6
7        // Traverse nums2 from right to left
8        for (int i = n - 1; i >= 0; i--) {
9    
10            // Pop all smaller or equal elements
11            while (!st.isEmpty() && st.peek() <= nums2[i]) {
12                st.pop();
13            }
14
15            // If stack empty, no greater element
16            if (st.isEmpty()) map.put(nums2[i], -1);
17            else map.put(nums2[i], st.peek());
18
19            // Push current number to stack
20            st.push(nums2[i]);
21        }
22
23        // Build result for nums1 using the map
24        int[] ans = new int[nums1.length];
25        for (int i = 0; i < nums1.length; i++) {
26            ans[i] = map.get(nums1[i]);
27        }
28
29        return ans;
30    }
31}
32
33     
34  