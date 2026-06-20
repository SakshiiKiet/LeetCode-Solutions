1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode sortList(ListNode head) {
13       
14        if (head == null || head.next == null) {
15            return head;
16        }
17
18        // Step 1: Find middle
19        ListNode middle = findMiddle(head);
20        ListNode rightHead = middle.next;
21        middle.next = null; 
22        ListNode leftHead = head;
23
24        // Step 2: Sort both halves recursively
25        leftHead = sortList(leftHead);
26        rightHead = sortList(rightHead);
27
28        // Step 3: Merge both halves
29        return merge(leftHead, rightHead);
30    }
31
32    // Function to find middle of linked list
33    public ListNode findMiddle(ListNode head) {
34        ListNode slow = head;
35        ListNode fast = head.next;
36        while (fast != null && fast.next != null) {
37            slow = slow.next;
38            fast = fast.next.next;
39        }
40        return slow;
41    }
42
43    // Merge two sorted linked lists
44    public ListNode merge(ListNode list1, ListNode list2) {
45     ListNode t1 = list1;
46        ListNode t2 = list2;
47
48        // Dummy node to simplify logic
49        ListNode dummy = new ListNode(-1);
50        ListNode current = dummy;
51
52        // Traverse both lists
53        while (t1 != null && t2 != null) {
54            if (t1.val < t2.val) {
55                current.next = t1;
56                t1 = t1.next;
57            } else {
58                current.next = t2;
59                t2 = t2.next;
60            }
61            current = current.next;
62        }
63
64        // Attach remaining nodes (only one list will have nodes left)
65        if (t1 != null) current.next = t1;
66        if (t2 != null) current.next = t2;
67
68        // Return head of merged sorted list
69        return dummy.next;
70    }
71}
72
73