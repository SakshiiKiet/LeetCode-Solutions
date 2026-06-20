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
15        // Step 1: count total nodes
16        int c = 0;
17        ListNode temp = head;
18        while (temp != null) {
19            c++;
20            temp = temp.next;
21        }
22
23        
24        if (n == c) {
25            return head.next;
26        }
27
28        int res=c-n;
29        temp = head;
30        while(temp!=null){
31            res--;
32            if(res==0){
33                temp.next=temp.next.next;
34                break;
35            }
36            temp=temp.next;
37        }
38
39        return head;
40    }
41}
42