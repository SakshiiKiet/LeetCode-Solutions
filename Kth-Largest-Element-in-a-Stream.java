1class KthLargest {
2   PriorityQueue<Integer>p;
3   int size;
4    public KthLargest(int k, int[] nums) {
5        p=new PriorityQueue<>();
6        size=k;
7        for(int i=0;i<nums.length;i++){
8            p.add(nums[i]);
9            if(p.size()>k){
10                p.poll();
11            }
12        }
13    }
14    
15    public int add(int val) {
16        p.add(val);
17        if(p.size()>size){
18                p.poll();
19            }
20            return p.peek();
21    }
22}
23
24/**
25 * Your KthLargest object will be instantiated and called as such:
26 * KthLargest obj = new KthLargest(k, nums);
27 * int param_1 = obj.add(val);
28 */