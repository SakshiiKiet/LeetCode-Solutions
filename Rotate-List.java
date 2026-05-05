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
12    public ListNode rotateRight(ListNode head, int k) {
13        if (head == null || head.next == null || k == 0) return head;
14        ListNode tail=head;
15        int len=1;
16        while(tail.next!=null){
17            len++;
18            tail=tail.next;
19        } 
20        if(k%len==0) return head;
21        k=k%len;
22        tail.next=head;
23        ListNode newlastNode=findnthNode(head,len-k);
24        head=newlastNode.next;
25        newlastNode.next=null; 
26        return head;
27    }
28   public ListNode findnthNode(ListNode temp,int k){
29    int c=1;
30    while(temp!=null){
31        if(c==k) return temp;
32        c++;
33        temp=temp.next;
34    }
35    return temp;
36   }
37}