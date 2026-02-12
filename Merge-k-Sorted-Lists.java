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
12    public ListNode mergeKLists(ListNode[] lists) {
13        if (lists == null || lists.length == 0)
14        return null;
15       mergesort(lists,0,lists.length-1);
16       return lists[0];
17    }
18   void mergesort(ListNode[] lists,int start,int end){
19    if(start>=end) return;
20    int mid=start+(end-start)/2;
21    mergesort(lists,start,mid);
22    mergesort(lists,mid+1,end);
23    lists[start]=merge(lists[start],lists[mid+1]);
24   }
25    public ListNode merge(ListNode list1, ListNode list2) {
26        if (list1 == null) return list2;
27        if (list2 == null) return list1;
28
29        if (list1.val < list2.val) {
30            list1.next = merge(list1.next, list2);
31            return list1;
32        } else {
33            list2.next = merge(list1, list2.next);
34            return list2;
35        }
36    }
37}
38