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
12    public ListNode removeNthFromEnd(ListNode head, int n) {
13        if (head == null) return null;
14
15        ListNode fast=head;
16        for(int i=0;i<n;i++){
17            fast=fast.next;
18        }
19        if(fast==null){
20                return head.next;
21            }
22        ListNode slow=head;
23        while(fast.next!=null){
24            slow=slow.next;
25            fast=fast.next;
26            }
27            
28       slow.next=slow.next.next;
29
30        return head;
31    }
32}
33