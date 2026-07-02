1/*
2// Definition for a Node.
3class Node {
4    int val;
5    Node next;
6    Node random;
7
8    public Node(int val) {
9        this.val = val;
10        this.next = null;
11        this.random = null;
12    }
13}
14*/
15
16class Solution {
17    public Node copyRandomList(Node head) {
18       Node temp=head;
19        HashMap<Node,Node>map=new HashMap<>();
20        while(temp!=null){
21            Node newNode=new Node(temp.val);
22            map.put(temp,newNode);
23            temp=temp.next;
24        }
25        temp=head;
26        while(temp!=null){
27            Node copyNode=map.get(temp);
28            copyNode.next=map.get(temp.next);
29            copyNode.random=map.get(temp.random);
30            temp=temp.next;
31        }
32        return map.get(head);
33    }
34}