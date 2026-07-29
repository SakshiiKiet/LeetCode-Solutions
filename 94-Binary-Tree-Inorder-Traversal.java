/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode node=root;
         List<Integer>list=new ArrayList<>();
         Stack<TreeNode>s=new Stack<>();
         while(true){
            if(node!=null){
                s.push(node);
                node=node.left;
            }
            else{
                if(s.isEmpty()) break;
                else{
                    node=s.pop();
                    list.add(node.val);
                    node=node.right;
                }
            }
         }
         return list;
    }
}
        
   