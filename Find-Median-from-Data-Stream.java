1class MedianFinder {
2 // Max-heap for smaller half
3    private PriorityQueue<Integer> maxHeap;
4
5    // Min-heap for larger half
6    private PriorityQueue<Integer> minHeap;
7    public MedianFinder() {
8         maxHeap = new PriorityQueue<>(Collections.reverseOrder());
9        minHeap = new PriorityQueue<>();
10    }
11    
12    public void addNum(int num) {
13        if(maxHeap.isEmpty()){
14            maxHeap.add(num); //leftheap
15            return;
16        }
17        if(num>maxHeap.peek()){
18            minHeap.add(num); //rightheap
19        }else{
20             maxHeap.add(num);
21        }
22        balanceHeaps();
23    }
24    private void balanceHeaps() {
25
26    // minheap size(right) should not be grater than maxheap size(left)
27    if (minHeap.size() > maxHeap.size()) {
28        maxHeap.add(minHeap.poll());
29    } 
30    else {
31        //diff bw minheap and maxheap should not be greater than 1
32        if (maxHeap.size() >minHeap.size() + 1) {
33           minHeap.add(maxHeap.poll());
34        }
35    }
36}
37
38    public double findMedian() {
39         if (maxHeap.size() == minHeap.size()) {
40            return (maxHeap.peek() + minHeap.peek()) / 2.0;
41        }
42
43        // Otherwise, return top of maxHeap
44        return maxHeap.peek();
45    }
46}
47
48/**
49 * Your MedianFinder object will be instantiated and called as such:
50 * MedianFinder obj = new MedianFinder();
51 * obj.addNum(num);
52 * double param_2 = obj.findMedian();
53 */