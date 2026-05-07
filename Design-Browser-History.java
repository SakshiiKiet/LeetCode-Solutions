1class ListNode {
2    String data;
3    ListNode prev, next;
4    ListNode(String data) {
5        this.data = data;
6    }
7}
8
9class BrowserHistory {
10    ListNode curr;
11
12    public BrowserHistory(String homepage) {
13        curr = new ListNode(homepage);
14    }
15
16    public void visit(String url) {
17        ListNode newNode = new ListNode(url);
18        // clear forward history
19        //curr.next = null;
20        // link new node
21        newNode.prev = curr;
22        curr.next = newNode;
23        curr = newNode;
24    }
25
26    public String back(int steps) {
27        while (steps > 0 && curr.prev != null) {
28            curr = curr.prev;
29            steps--;
30        }
31        return curr.data;
32    }
33
34    public String forward(int steps) {
35        while (steps > 0 && curr.next != null) {
36            curr = curr.next;
37            steps--;
38        }
39        return curr.data;
40    }
41}
42
43
44
45/**
46 * Your BrowserHistory object will be instantiated and called as such:
47 * BrowserHistory obj = new BrowserHistory(homepage);
48 * obj.visit(url);
49 * String param_2 = obj.back(steps);
50 * String param_3 = obj.forward(steps);
51 */