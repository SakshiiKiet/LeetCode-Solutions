1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
14     ListNode t1=headA;
15     int N1=0;
16     while(t1!=null){
17        t1=t1.next;
18        N1++;
19     }
20          ListNode t2=headB;
21     int N2=0;
22     while(t2!=null){
23        t2=t2.next;
24         N2++;
25     }
26
27if(N1<N2){
28    return collisionPoint(headA,headB,N2-N1);
29}else{
30    return collisionPoint(headB,headA,N1-N2);
31}
32
33    }
34 public ListNode  collisionPoint(ListNode t1, ListNode t2,int d){
35   while(d!=0){
36    t2=t2.next;
37     d--;
38   }
39   while(t1!=t2){
40    t1=t1.next;
41    t2=t2.next;
42   }
43   return t1;
44    }
45}