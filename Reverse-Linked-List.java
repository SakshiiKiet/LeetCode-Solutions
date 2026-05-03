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
12    public ListNode reverseList(ListNode head) {
13        ListNode curr=head,prev=null;
14        while(curr!=null){
15            ListNode nxt=curr.next;
16            curr.next=prev;
17            prev=curr;
18            curr=nxt;
19        }
20        return prev;
21    }
22}