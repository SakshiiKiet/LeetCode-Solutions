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
12    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
13        ArrayList<Integer>list=new ArrayList<>();
14        ListNode temp1=list1;
15        while(temp1!=null){
16         list.add(temp1.val);
17          temp1=temp1.next;
18        }
19        ListNode temp2=list2;
20        while(temp2!=null){
21         list.add(temp2.val);
22          temp2=temp2.next;
23        }
24        Collections.sort(list);
25        return convert(list);
26    }
27 public ListNode convert(ArrayList<Integer>list){
28    ListNode dummy=new ListNode(-1);
29    ListNode curr=dummy;
30    for(int val:list){
31        curr.next= new ListNode(val);
32        curr=curr.next;
33    }
34    return dummy.next;
35 }
36}