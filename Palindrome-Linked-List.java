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
12    public boolean isPalindrome(ListNode head) {
13        if(head==null || head.next==null) return true;
14        ListNode slow=head;
15        ListNode fast=head;
16        while(fast.next!=null && fast.next.next!=null){
17            slow=slow.next;
18            fast=fast.next.next;
19        }
20        ListNode newHead=reverse(slow.next);
21        ListNode first=head;
22        ListNode second=newHead;
23        while(second!=null){
24            if(first.val!=second.val){
25                reverse(newHead);
26                return false;
27            }
28            first=first.next;
29            second=second.next;
30        }
31        reverse(newHead);
32        return true;
33    }
34    public static ListNode reverse(ListNode head){
35         if(head==null || head.next==null) return head;
36        ListNode prev = null;
37        while(head != null){
38            ListNode next = head.next;
39            head.next = prev;
40            prev = head;
41            head = next;
42        }
43        return prev;
44    }
45}