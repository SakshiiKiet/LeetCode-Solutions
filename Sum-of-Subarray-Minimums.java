1
2class Solution {
3    public int sumSubarrayMins(int[] arr) {
4        int n = arr.length;
5        int mod = (int)1e9 + 7;
6
7        int[] nse = findNSE(arr); // Next Smaller Element
8        int[] pse = findPSEE(arr); // Previous Smaller Element
9
10        long total = 0;
11
12        for (int i = 0; i < n; i++) {
13            long left = i - pse[i];
14            long right = nse[i] - i;
15
16            total = (total + (left * right % mod) * arr[i] % mod) % mod;
17        }
18
19        return (int) total;
20    }
21
22    // Find index of Next Smaller Element (to the right)
23    private int[] findNSE(int[] arr) {
24        int n = arr.length;
25        int[] nse = new int[n];
26        Stack<Integer> st = new Stack<>();
27
28        for (int i = n - 1; i >= 0; i--) {
29            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
30                st.pop();
31            }
32            if(st.isEmpty()) nse[i]=n;
33            else nse[i]=st.peek();
34            st.push(i);
35        }
36        return nse;
37    }
38
39    // Find index of Previous Smaller Element (to the left)
40    private int[] findPSEE(int[] arr) {
41        int n = arr.length;
42        int[] psee = new int[n];
43        Stack<Integer> st = new Stack<>();
44
45        for (int i = 0; i < n; i++) {
46            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
47                st.pop();
48            }
49             if(st.isEmpty()) psee[i]=-1;
50            else psee[i]=st.peek();
51            st.push(i);
52        }
53        return psee;
54    }
55}
56