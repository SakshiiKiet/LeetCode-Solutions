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
12    public ListNode reverseKGroup(ListNode head, int k) {
13        ListNode temp=head;
14        ListNode prevLast=null;
15        while(temp!=null){
16            ListNode kthNode=getkthNode(temp,k);
17            if(kthNode==null){
18                if(prevLast!=null) prevLast.next=temp;
19                break;
20            }
21            ListNode nextNode=kthNode.next;
22            kthNode.next=null;
23            reverse(temp);
24            if(temp==head){
25                head=kthNode;
26            }else{
27                prevLast.next=kthNode;
28            }
29             prevLast=temp;
30                temp=nextNode;
31            }
32            return head;
33        }
34    
35    public ListNode getkthNode(ListNode temp, int k){
36        k-=1;
37        while(temp!=null && k>0){
38            k--;
39            temp=temp.next;
40        }
41        return temp;
42    }
43    public ListNode reverse(ListNode temp){
44        ListNode prev=null;
45        ListNode curr=temp;
46        while(curr!=null){
47        ListNode nxt=curr.next;
48        curr.next=prev;
49        prev=curr;
50        curr=nxt;
51        }
52      return prev;
53    }
54    }
55