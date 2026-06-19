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
12    public ListNode removeElements(ListNode head, int val) {
13        while(head!=null && head.val==val){
14            head=head.next;
15        }
16        ListNode temp=head;
17        ListNode prev=null;
18        while(temp!=null){
19            if(temp.val==val){
20                prev.next=prev.next.next;
21            }
22            else{
23                prev=temp;
24            }
25            temp=temp.next;
26        }
27      return head;
28    }
29}