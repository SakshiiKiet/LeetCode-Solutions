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
13        if(head==null) return null;
14        while(head!=null && head.val==val){
15            head=head.next;
16        }
17        ListNode temp=head;
18        ListNode prev=null;
19        while(temp!=null){
20            if(temp.val==val){
21                prev.next=prev.next.next;
22            }
23            else{
24                prev=temp;
25            }
26            temp=temp.next;
27        }
28      return head;
29    }
30}