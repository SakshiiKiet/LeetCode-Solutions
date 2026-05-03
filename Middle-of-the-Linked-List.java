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
12    public ListNode middleNode(ListNode head) {
13        int c=0;
14        ListNode temp=head;
15        while(temp!=null){
16            temp=temp.next;
17            c++;
18        }
19        int midNode=(c/2)+1;
20        temp=head;
21        while(temp!=null){
22            midNode--;
23            if(midNode==0){
24                break;
25            }
26            temp=temp.next;
27        }
28        return temp;
29    }
30}