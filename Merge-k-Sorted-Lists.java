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
11 class Solution{
12public ListNode mergeKLists(ListNode[] lists) {
13
14    if (lists == null || lists.length == 0)
15        return null;
16
17    // Min Heap based on node value
18    PriorityQueue<ListNode> pq =
19        new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
20
21    // Add first node of each list
22    for (ListNode node : lists) {
23        if (node != null)
24            pq.add(node);
25    }
26
27    // Dummy node (same as root )
28   // 0->1->....
29    ListNode root = new ListNode(0);
30    ListNode tail = root;
31
32    while (!pq.isEmpty()) {
33        ListNode temp = pq.poll();
34        tail.next = temp;
35        tail = tail.next;  
36        if (temp.next != null)
37            pq.add(temp.next);
38    }
39
40    return root.next;
41   // 1->2->...
42}
43 }
44
45