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

    // Helper class to store node along with its coordinates
    class Tuple {
        TreeNode node;
        int vertical;
        int level;

        Tuple(TreeNode node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap maintains sorted order of columns (x)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int x = t.vertical;
            int y = t.level;

            // Insert into map
           if(!map.containsKey(x)){ 
            map.put(x,new TreeMap<>());
             } 
             if(!map.get(x).containsKey(y)){ 
                map.get(x).put(y,new PriorityQueue<>());
              } 
              map.get(x).get(y).offer(node.val);

            // Add left and right children with updated coordinates
            if (node.left != null)
                q.offer(new Tuple(node.left, x - 1, y + 1));
            if (node.right != null)
                q.offer(new Tuple(node.right, x + 1, y + 1));
        }

        // Construct final result
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue<Integer> pq : ys.values()) {
                while (!pq.isEmpty())
                    col.add(pq.poll());
            }
            ans.add(col);
        }

        return ans;
    }
}
