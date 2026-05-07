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
12    public ListNode reverseBetween(ListNode head, int left, int right) {
13        if (head == null || left == right) return head;
14        ListNode curr=head;
15        ListNode prev=null;
16        for(int i=1;i<left;i++){
17            prev=curr;
18            curr=curr.next;
19        }
20        ListNode last=prev;
21        ListNode newEnd=curr;
22        
23        for(int i=left;i<=right;i++){
24            ListNode nxt=curr.next;
25            curr.next=prev;
26            prev=curr;
27            curr=nxt; 
28        }
29        if(last!=null){
30            last.next=prev;
31        }else{
32            head=prev;
33        }
34      
35      newEnd.next=curr;
36      return head;
37    }
38}