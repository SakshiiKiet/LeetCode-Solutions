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
12    public ListNode deleteMiddle(ListNode head) {
13        if (head == null || head.next == null)
14            return null;
15        ListNode slow=head;
16        ListNode fast=head;
17        fast=fast.next.next;
18        while(fast!=null && fast.next!=null){
19            slow=slow.next;
20            fast=fast.next.next;
21        }
22        slow.next=slow.next.next;
23
24        return head;
25    
26    }
27}