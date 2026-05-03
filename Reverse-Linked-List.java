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
13        Stack<Integer>st=new Stack<>();
14        ListNode temp=head;
15        while(temp!=null){
16            st.push(temp.val);
17            temp=temp.next;
18        }
19        temp=head;
20        while(temp!=null){
21            temp.val=st.pop();
22            temp=temp.next;
23        }
24        return head;
25    }
26}