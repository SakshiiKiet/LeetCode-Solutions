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
12 public ListNode mergeKLists(ListNode[] lists) {
13        // List to collect all node values
14        List<Integer> allValues = new ArrayList<>();
15
16        // Traverse each linked list
17        for (ListNode head : lists) {
18            while (head != null) {
19                allValues.add(head.val);
20                head = head.next;
21            }
22        }
23
24        // Sort the collected values
25        Collections.sort(allValues);
26
27        // Create dummy node for result list
28        ListNode dummy = new ListNode(0);
29        ListNode curr = dummy;
30
31        // Create new nodes from sorted values
32        for (int val : allValues) {
33            curr.next = new ListNode(val);
34            curr = curr.next;
35        }
36
37        return dummy.next;
38}
39 }
40
41